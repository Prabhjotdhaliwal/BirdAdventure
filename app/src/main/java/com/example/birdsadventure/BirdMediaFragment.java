package com.example.birdsadventure;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;


public class BirdMediaFragment extends Fragment {
    ImageView videothumnail;
    Button playSound;
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    ProgressBar soundProgressBar;
    SeekBar  seekBarprogress;
    Boolean isPlaying =false;


    String file_path="https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";

    public BirdMediaFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.fragment_bird_media, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);

        videothumnail=view.findViewById (R.id.videothumnail);
        playSound=view.findViewById (R.id.soundplaybtn);
        seekBarprogress = (SeekBar)view.findViewById (R.id.seekbarProgress);
        seekBarprogress.setVisibility (View.INVISIBLE);

        videothumnail.setOnClickListener (new View.OnClickListener ()
        {
            @Override
            public void onClick(View v)
            {
                Log.d (TAG,"onClick: Initializing You tube player");
                Intent Intent = new Intent (getActivity(), BirdVideoplayerActivity2.class);
                getActivity().startActivity(Intent);
            }
        });



        playSound.setOnClickListener (new View.OnClickListener ()
        {
            @Override
            public void onClick(View v)
            {



                if (isPlaying) {
                    pause ();
                    playSound.setBackgroundResource (R.mipmap.playbtn);
                }else{
                    play ();
                    playSound.setBackgroundResource (R.mipmap.pause);

                }
                isPlaying = !isPlaying;
            }

        });





    }
private  void play()
{
    try {
        mediaPlayer = new MediaPlayer ();
        mediaPlayer.setAudioStreamType (AudioManager.STREAM_MUSIC);

        mediaPlayer.setDataSource(getActivity (), Uri.parse (file_path));
        mediaPlayer.prepare ();
        mediaPlayer.start ();
        setProgressbar ();

       // Toast.makeText (getActivity (),"playBack",Toast.LENGTH_LONG).show ();

    }
    catch (IOException e)
    {
        e.printStackTrace ();
    }
}

    private  void pause()
    {
        mediaPlayer.stop ();
    }


    //setprogressbar
    public void setProgressbar(){
        seekBarprogress.setVisibility (View.VISIBLE);
        seekBarprogress.setMax (mediaPlayer.getDuration ());
        seekBarprogress.setOnSeekBarChangeListener (new SeekBar.OnSeekBarChangeListener () {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                mediaPlayer.seekTo (i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
//mediaPlayer.start ();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//mediaPlayer.pause ();
            }
        });

        new Timer ().scheduleAtFixedRate (new TimerTask () {
            @Override
            public void run()
            {
                seekBarprogress.setProgress (mediaPlayer.getCurrentPosition ());
            }
        },0,500);}
}