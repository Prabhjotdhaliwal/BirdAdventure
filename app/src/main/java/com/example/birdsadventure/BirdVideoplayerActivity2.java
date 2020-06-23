package com.example.birdsadventure;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class BirdVideoplayerActivity2 extends YouTubeBaseActivity {

    Button playButton;
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_videoplayer2);

        final String videoUrlID = getIntent().getStringExtra("videoUrlID");

        playButton = findViewById(R.id.btnVideoPlay);
        youTubePlayerView = findViewById(R.id.youTubeView);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                //List<String> videoList = new ArrayList<>();
                //videoList.add("jHGaFJMkHvM");
                //String value = "jHGaFJMkHvM";
                youTubePlayer.loadVideo(videoUrlID);

                //youTubePlayer.loadPlaylist ("PLBm3q1VIzvkZHsAL8ajiGxY6ElF76fBEC");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize(YouTubeConfig.getApiKey(), onInitializedListener);

            }
        });
    }
}