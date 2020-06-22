package com.example.birdsadventure;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ImagesCollectionFragment extends Fragment {
private RecyclerView recyclerView;
ImageAdapter adapter;
FirebaseFirestore db;
    StorageReference storageReference;
    GridView simpleImageGrid;
    int birdPictures[] = {R.drawable.b1, R.drawable.b2, R.drawable.b4, R.drawable.b5,
            R.drawable.b6,R.drawable.b8, R.drawable.b16, R.drawable.birddemothiumnail, R.drawable.b11,
            R.drawable.b12, R.drawable.b1, R.drawable.b15, R.drawable.b16,R.drawable.b18};
    String birdPicturesnames[] = {"bird1", "bird2", "bird3", "bird4",
            "bird5","bird6", "bird7", "bird8", "bird9",
            "bird10", "bird11", "bird12", "bird13","bird14"};



    public ImagesCollectionFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        if (getArguments () != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate (R.layout.fragment_images_collection, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        db = FirebaseFirestore.getInstance();
        simpleImageGrid = view.findViewById(R.id.simpleGridView); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        ImageAdapter imageAdapter = new ImageAdapter (getActivity (), birdPictures,birdPicturesnames);
        simpleImageGrid.setAdapter(imageAdapter);
        // implement setOnItemClickListener event on GridView
        simpleImageGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText (getActivity (),"bird image selected" ,Toast.LENGTH_LONG).show ();
                // set an Intent to Another Activity
             //  Intent intent = new Intent(getActivity (), GalleryImageviewFragment.class);
              //  intent.putExtra("image", birdPictures[position]); // put image data in Intent
              //  getActivity().startActivity(intent); // start Intent
            }
        });

    }
}