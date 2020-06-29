package com.example.birdsadventure;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class LibraryFragment extends Fragment implements View.OnClickListener {
ImageButton imagefolderbtn,videofolderbtn,soundsfolderbtn;
    private NavController navController;

    public LibraryFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_library, container, false);


    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated (view, savedInstanceState);
       imagefolderbtn=view.findViewById (R.id.image_btn);
        videofolderbtn=view.findViewById (R.id.video_btn);
        soundsfolderbtn=view.findViewById (R.id.sound_btn);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

  imagefolderbtn.setOnClickListener (this);
  videofolderbtn.setOnClickListener (this);
  soundsfolderbtn.setOnClickListener (this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_btn:
               // Toast.makeText (getActivity (),"Images folder selected",Toast.LENGTH_LONG).show ();
                navController.navigate(R.id.imagesCollectionFragment);
                break;
            case R.id.video_btn:
                //Toast.makeText (getActivity (),"Videos folder selected",Toast.LENGTH_LONG).show ();
                navController.navigate(R.id.videosCollectionFragment);

                break;
            case R.id.sound_btn:
               // Toast.makeText (getActivity (),"Sounds folder selected",Toast.LENGTH_LONG).show ();
                navController.navigate(R.id.soundsCollectionFragment);
                break;

            default:
                break;
    }
}}
