package com.example.birdsadventure;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class BirdMediaFragment extends Fragment {



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

        ImageView videothumnail;
        videothumnail=view.findViewById (R.id.videothumnail);



        videothumnail.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v)
            {
                Log.d (TAG,"onClick: Initializing You tube player");
                Intent Intent = new Intent (getActivity(), BirdVideoplayerActivity2.class);
                getActivity().startActivity(Intent);
            }
        });
    }


}