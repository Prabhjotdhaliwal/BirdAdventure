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
    private List< StorageReference > myImages;

    public SoundsCollectionFragment() {
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
        imgcollect=view.findViewById (R.id.imagecollect1);
        recyclerView=view.findViewById (R.id.imagesCollection_recyclerView);
        recyclerView.setHasFixedSize (true);
        recyclerView.setLayoutManager (new LinearLayoutManager (getActivity ()));

        myImages=new ArrayList< StorageReference > ();
        //


        // storageReference = FirebaseStorage.getInstance().getReference("pictures/JPEG_20200607_200707_1933836298.jpg");
        // storageReference = FirebaseStorage.getInstance().getReference("pictures/");

       // listFiles ();
    }

   /* private  void listFiles()
    {
        storageReference = FirebaseStorage.getInstance().getReference("audio/");

        storageReference.listAll()
                .addOnSuccessListener(new OnSuccessListener< ListResult >() {
                    @Override
                    public void onSuccess(ListResult listResult) {
                        for (StorageReference prefix : listResult.getPrefixes()) {
                            // All the prefixes under listRef.
                            // You may call listAll() recursively on them.
                        }

                        for (StorageReference item : listResult.getItems()) {
                            // All the items under listRef.
                            System.out.println (item);
                            Toast.makeText (getActivity (),"successfully loaded the Sounds",Toast.LENGTH_LONG).show ();

                            myImages.add (item);

                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Uh-oh, an error occurred!
                    }
                });
    }*/
}