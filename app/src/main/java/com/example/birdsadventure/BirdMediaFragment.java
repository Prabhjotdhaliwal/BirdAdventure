package com.example.birdsadventure;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class BirdMediaFragment extends Fragment implements View.OnClickListener {

    ImageView videoThumbnail, birdMediaImage;
    Button btnSoundPlay;
    SeekBar soundSeekBarProgress;

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    ProgressBar soundProgressBar;
    Boolean isPlaying = false;

    String audioUrl;
    String imageUrl;
    String videoUrlID;
    String birdID;
    Bird currentBird;
    FirebaseFirestore db;

    SharedPreferences sp;

    public BirdMediaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bird_media, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = FirebaseFirestore.getInstance();

        birdMediaImage = view.findViewById(R.id.birdMediaImage);
        videoThumbnail = view.findViewById(R.id.videoThumbnail);
        btnSoundPlay = view.findViewById(R.id.btnSoundPlay);
        soundSeekBarProgress = (SeekBar) view.findViewById(R.id.soundSeekBarProgress);
        soundSeekBarProgress.setVisibility(View.INVISIBLE);

        videoThumbnail.setOnClickListener(this);
        btnSoundPlay.setOnClickListener(this);

        //videoThumbnail.setVisibility(View.VISIBLE);

        sp = getActivity().getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
        birdID = sp.getString(MyVariables.keyBirdID, MyVariables.defaultBirdID);

        getBirdDetails();

    }

    private void getBirdDetails() {
        currentBird = new Bird();

        if (birdID != null) {

            if (birdID.equals("")) {
                Toast.makeText(getActivity().getApplicationContext(), "Bird Data not found", Toast.LENGTH_SHORT).show();
                return;
            }

            db.collection("Birds").document(birdID).collection("media")
                    .whereEqualTo("is_deleted", false).get().
                    addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {

                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if (document.getBoolean("is_image")) {

                                        imageUrl = document.getString("url");
                                        Picasso.get().load(imageUrl).into(birdMediaImage);

                                    } else if (document.getBoolean("is_video")) {

                                        String videoUrl = document.getString("url");

                                        videoUrlID = videoUrl.substring(videoUrl.indexOf('=') + 1);
                                        //String thumbnail = "http://img.youtube.com/vi/" + videoUrlID + "/0.jpg";

                                        //Picasso.get().load(thumbnail).into(videoThumbnail);

                                    } else if (document.getBoolean("is_sound_clip")) {
                                        audioUrl = document.getString("url");
                                        //audioUrl = "https://www.xeno-canto.org/sounds/uploaded/KZYUWIRZVH/XC439903-CARDINA_Northern%20No%203%20Uvalama%20400m%20071918%200711.mp3";
                                    }
                                }
                            }
                        }
                    });
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.videoThumbnail) {

            Intent intent = new Intent(getActivity(), BirdVideoplayerActivity2.class);
            intent.putExtra("videoUrlID", videoUrlID);
            getActivity().startActivity(intent);

        } else if (v.getId() == R.id.btnSoundPlay) {

            if (isPlaying) {
                pause();
                btnSoundPlay.setBackgroundResource(R.mipmap.playbtn);
            } else {
                play();
                btnSoundPlay.setBackgroundResource(R.mipmap.pause);

            }
            isPlaying = !isPlaying;

        }
    }

    private void play() {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

            mediaPlayer.setDataSource(getActivity(), Uri.parse(audioUrl));
            mediaPlayer.prepare();
            mediaPlayer.start();
            setProgressbar();

            // Toast.makeText (getActivity (),"playBack",Toast.LENGTH_LONG).show ();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pause() {
        mediaPlayer.stop();
    }

    public void setProgressbar() {
        soundSeekBarProgress.setVisibility(View.VISIBLE);
        soundSeekBarProgress.setMax(mediaPlayer.getDuration());
        soundSeekBarProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                mediaPlayer.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//mediaPlayer.start ();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//mediaPlayer.pause ();
            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                soundSeekBarProgress.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 500);
    }

}