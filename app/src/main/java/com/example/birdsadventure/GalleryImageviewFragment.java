package com.example.birdsadventure;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class GalleryImageviewFragment extends Fragment {


    public GalleryImageviewFragment() {
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


        return inflater.inflate ( R.layout.fragment_gallery_imageview, container, false );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated ( view, savedInstanceState );
        ImageView selectedImage;
        selectedImage = view.findViewById(R.id.selectedImage); // init a ImageView
       // Intent intent = Intent.getIntent (); // get Intent which we set from Previous Activity
      //  selectedImage.setImageResource(intent.getIntExtra("image", 0)); // get image from Intent and set it in ImageView
       // Intent intent = new Intent(); // get Intent which we set from Previous Activity

     //   int addID = intent.getIntExtra("addressID", 0);
        //selectedImage.setImageResource(intent.getIntExtra("image", 0));
    }
}