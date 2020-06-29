package com.example.birdsadventure;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

public class SoundPlayerFragment extends Fragment implements View.OnClickListener {


    SeekBar soundSeekBarProgress;
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    ProgressBar soundProgressBar;
    Boolean isPlaying = false;
    Button soundPlayerBtn,saveSoundBtn,shareSoundBtn;
    String title="Sound";

    String mediaID;

    public SoundPlayerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sound_player, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated ( view, savedInstanceState );
        soundPlayerBtn = view.findViewById( R.id.SoundPlaybtn);
        saveSoundBtn = view.findViewById( R.id.saveSoundbtn);
        shareSoundBtn = view.findViewById( R.id.shareSoundbtn);
        soundSeekBarProgress = (SeekBar) view.findViewById( R.id.soundSeekBarProgress2);
        soundSeekBarProgress.setVisibility(View.INVISIBLE);

        String birdsoundUrl = getArguments().getString("librarySound");


        soundPlayerBtn.setOnClickListener ( this );


        saveSoundBtn.setOnClickListener ( new View.OnClickListener ()
        {
            @Override
            public void onClick(View v)
            {
                saveSound ();
            }
        } );
        shareSoundBtn.setOnClickListener ( new View.OnClickListener ()
        {
            @Override
            public void onClick(View v)
            {
                shareSound ();
            }
        } );

    }

    @Override
    public void onClick(View v)
    {

        if (isPlaying) {
            pause();
            soundPlayerBtn.setBackgroundResource(R.mipmap.playbtn);
        } else {
            play();
            soundPlayerBtn.setBackgroundResource(R.mipmap.pause);

        }
        isPlaying = !isPlaying;




        }




    private void shareSound()

    {

        String birdsoundUrl = getArguments().getString("librarySound");

        Uri uri = Uri.parse(birdsoundUrl);
        File file = new File((uri.getPath()));



      //  Uri uri=Uri.parse (birdsoundUrl  );
        Intent share= new Intent ( Intent.ACTION_SEND );
        share.setType ( "audio/*" );

        share.putExtra (Intent.EXTRA_STREAM,file  );
        startActivity ( Intent
        .createChooser ( share,"Share sound File" ));

        Toast.makeText ( getActivity (),"shareSoundSelected",Toast.LENGTH_LONG ).show ();
    }

    private void saveSound() {
       // Toast.makeText ( getActivity (),"saveSoundSelected",Toast.LENGTH_LONG ).show ();
        String birdsoundUrl = getArguments().getString("librarySound");
     downloadManager ( birdsoundUrl );
    }

    private void downloadManager(String url) {

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setDescription("download");
        request.setTitle("myvideo"+title);
// in order for this if to run, you must use the android 3.2 to compile your app
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, ""+title+".mp3");

// get download service and enqueue file
        DownloadManager manager = (DownloadManager) getActivity ().getSystemService( Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
        Toast.makeText(getActivity(), "Audio Saved", Toast.LENGTH_LONG).show();

    }
    private void play() {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

            String birdsoundUrl = getArguments().getString("librarySound");

            mediaPlayer.setDataSource(getActivity(), Uri.parse(birdsoundUrl));
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

        new Timer ().scheduleAtFixedRate( new TimerTask () {
            @Override
            public void run() {
                soundSeekBarProgress.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 500);
    }

}