package com.example.birdsadventure;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
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


public class VideosCollectionFragment extends Fragment {
    private RecyclerView recyclerView;
    ImageAdapter adapter;
    FirebaseFirestore db;
    StorageReference storageReference;
    private ArrayList<Media> MediaList;
    NavController navController;
    GridView simpleVideoGrid;


    int birdPictures[] = {R.drawable.b1, R.drawable.b2, R.drawable.b4, R.drawable.b5,
            R.drawable.b6,R.drawable.b8, R.drawable.b16, R.drawable.birddemothiumnail, R.drawable.b11,
            R.drawable.b12, R.drawable.b1, R.drawable.b15, R.drawable.b16,R.drawable.b18};


    public VideosCollectionFragment() {
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

        return inflater.inflate (R.layout.fragment_videos_collection, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        db = FirebaseFirestore.getInstance();
        navController = Navigation.findNavController(getActivity (), R.id.nav_host_fragment);
         simpleVideoGrid= view.findViewById(R.id.simpleGridView1); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        ImageAdapter imageAdapter = new ImageAdapter (getActivity (), birdPictures);
        simpleVideoGrid.setAdapter(imageAdapter);



        // implement setOnItemClickListener event on GridView
        simpleVideoGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText (getActivity (),"bird image selected" ,Toast.LENGTH_LONG).show ();

                //send  selected image info to another actiivity

                // Bundle b=new Bundle();
                // b.putParcelable("media",MediaList.get(position));
                navController.navigate(R.id.galleryImageviewFragment);
            }
        });

    }
}


