package com.example.birdsadventure;

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
private ImageView imgcollect;
FirebaseFirestore db;
    StorageReference storageReference;
    private ArrayList< String > myImages;
    static final List<UserCollectionitem> ITEMS = new ArrayList<>();

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
 imgcollect=view.findViewById (R.id.imagecollect1);
        recyclerView=view.findViewById (R.id.imagesCollection_recyclerView);
    recyclerView.setHasFixedSize (true);
    recyclerView.setLayoutManager (new LinearLayoutManager (getActivity ()));

    myImages=new ArrayList< String > () ;

        //


       // storageReference = FirebaseStorage.getInstance().getReference("pictures/");
       try {
            getimages ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        listFiles ();
    }



    private void getimages() throws IOException {


        // storageReference = storageReference.child("pictures/JPEG_20200609_042028_2114832967.jpg");
      //  storageReference = storageReference.child("pictures/JPEG_20200609_042028_2114832967.jpg");

        final File localFile = File.createTempFile("images", "jpg");
        storageReference = FirebaseStorage.getInstance().getReference("pictures/JPEG_20200607_200707_1933836298.jpg");

        storageReference.getFile(localFile).addOnSuccessListener(new OnSuccessListener< FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                // Local temp file has been created
                //imgcollect.setImageResource ();
                imgcollect.setImageURI(Uri.fromFile(localFile));

                //get the shareable url
                storageReference.child("pictures/JPEG_20200609_042028_2114832967.jpg").getDownloadUrl().
                        addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                // Got the download URL for 'users/me/profile.png'
                                //  System.out.println (uri);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle any errors
                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
    }


    private  void listFiles()
    {
         storageReference = FirebaseStorage.getInstance().getReference("pictures/");

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
                          //  UserCollectionitem userCollectionitem=new UserCollectionitem ();
                            System.out.println (item);
                            Toast.makeText (getActivity (),"successfully loaded the images",Toast.LENGTH_LONG).show ();
                            System.out.println ("Jottttttttttttttttttttttttttttttttttttttttttttttttttt");

                          //  myImages.add (item.toString ());
                          //  String birdImageURL = document.getString("birdimgUrl");
                            myImages.add(item.toString ());
                            UserCollectionitem userCollectionitem=new UserCollectionitem ();
                            System.out.println (myImages);
                         //   imgcollect.setImageURI(Uri.fromFile(localFile));

                            adapter=new ImageAdapter (getActivity (),myImages);
                      recyclerView.setAdapter (adapter);

                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Uh-oh, an error occurred!
                    }
                });
    }
}