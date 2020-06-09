package com.example.birdsadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class BirdVideoplayerActivity2 extends YouTubeBaseActivity {
    Button playButton;
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_bird_videoplayer2);


        playButton=findViewById (R.id.videoplaybutton);
        youTubePlayerView=findViewById (R.id.youtubeview);
                onInitializedListener=new YouTubePlayer.OnInitializedListener ()
                {
@Override
public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        Log.d (TAG,"onClick:DoneIntializing");

        //for mulitple videos pass list
        List<String> videoList=new ArrayList<> ();
        videoList.add ("jHGaFJMkHvM");
        String value="jHGaFJMkHvM";
        youTubePlayer.loadVideo("jHGaFJMkHvM");

        //for playlist
        //   youTubePlayer.loadPlaylist ("PLBm3q1VIzvkZHsAL8ajiGxY6ElF76fBEC");
        }

@Override
public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        }
        };

                playButton.setOnClickListener (new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        youTubePlayerView.initialize (YouTubeConfig.getApiKey (),onInitializedListener);

                    }
                });
    }
}