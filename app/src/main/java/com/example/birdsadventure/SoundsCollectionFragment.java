package com.example.birdsadventure;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;


public class SoundsCollectionFragment extends Fragment {
    private RecyclerView recyclerView;
    private ImageView imgcollect;
    FirebaseFirestore db;
    StorageReference storageReference;

    public SoundsCollectionFragment() {
        // Required empty public constructor
    }

RecyclerView recyclerViewsounds;
    List<soundCollections> itemList;




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

       View view= inflater.inflate (R.layout.fragment_sounds_collection, container, false);
        recyclerViewsounds=view.findViewById(R.id.recyler_View_soundscollection);
        recyclerViewsounds.setHasFixedSize(true);
       recyclerViewsounds.setLayoutManager(new LinearLayoutManager(getContext()));
       //initdata();

recyclerViewsounds.setAdapter(new soundCollectionAdapter(initdata()));

       return  view;

    }

    private List<soundCollections> initdata() {

        itemList =new ArrayList<>();
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));
        itemList.add(new soundCollections("this is first sound"));



     return itemList;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        db = FirebaseFirestore.getInstance();
//


    }


}