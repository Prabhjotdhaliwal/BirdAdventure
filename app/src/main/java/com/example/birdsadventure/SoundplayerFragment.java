package com.example.birdsadventure;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class SoundplayerFragment extends Fragment  implements View.OnClickListener {
    SeekBar soundSeekBarProgress;

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    ProgressBar soundProgressBar;
    Boolean isPlaying = false;
    Button SoundPlayerBtn;
    String birdsoundUrl;
    String mediaID;
     SoundplayerFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate ( R.layout.fragment_soundplayer, container, false );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated ( view, savedInstanceState );
        SoundPlayerBtn = view.findViewById( R.id.SoundPlaybtn);
        soundSeekBarProgress = (SeekBar) view.findViewById( R.id.soundSeekBarProgress2);
        soundSeekBarProgress.setVisibility(View.INVISIBLE);
        birdsoundUrl = getArguments().getString("librarySound");
        /**
         * use this media id to delete this media from user/media collection.
         */
        mediaID = getArguments().getString("mediaID");

        //SoundPlayerBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

    }
}


