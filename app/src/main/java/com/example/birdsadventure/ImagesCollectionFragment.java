package com.example.birdsadventure;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class ImagesCollectionFragment extends Fragment {
private RecyclerView recyclerView;
ImageAdapter adapter;
    String imageUrl;
    String audioUrl;
    String videoUrlID;
    String userID;
    User currentUser;



    FirebaseUser user;
    FirebaseFirestore db;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    StorageReference storageReference;
    private ArrayList<Media> MediaList;
    private ArrayList< String > imagesList;

    NavController navController;
    GridView simpleImageGrid;


   /* int birdPictures[] = {R.drawable.b1, R.drawable.b2, R.drawable.b4, R.drawable.b5,
            R.drawable.b6,R.drawable.b8, R.drawable.b16, R.drawable.birddemothiumnail, R.drawable.b11,
            R.drawable.b12, R.drawable.b1, R.drawable.b15, R.drawable.b16,R.drawable.b18};*/


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

        navController = Navigation.findNavController(getActivity (), R.id.nav_host_fragment);
        simpleImageGrid = view.findViewById(R.id.simpleGridView); // init GridVie
        getUserDetails ();
// w
        // Create an object of CustomAdapter and set Adapter to GirdView



        // implement setOnItemClickListener event on GridView
        simpleImageGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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


    private void getUserDetails() {
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            String email = user.getEmail();

            db.collection("Users").whereEqualTo("email", email)
                    .whereEqualTo("status", true).get()
                    .addOnCompleteListener(new OnCompleteListener< QuerySnapshot > () {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                QuerySnapshot documents = task.getResult();
                                if (documents.getDocuments().size() > 0) {
                                    userID = documents.getDocuments().get(0).getId();

                                    sp = getActivity().getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
                                    editor = sp.edit();
                                    editor.putString(MyVariables.keyUserDocID, userID);
                                    editor.apply();
                                    getuserCollectionMediaUrl ();

                                }
                            }
                        }
                    });
        }
    }


    private void getuserCollectionMediaUrl()
    {

        if (userID != null)
        {
            db.collection("Users").document(userID).collection("Media")
                    .whereEqualTo("is_deleted", false).get().
                    addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {

                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if (document.getBoolean("is_image"))
                                    {
                                      //  Log.d(TAG, document.getId() + " => " + document.getData());
                                        imageUrl = document.getString("url");
                                        Media media = new Media ( imageUrl, true, false,  false,  false) ;


                                        //list of imageUrls
                                       imagesList=new ArrayList<> ();
                                       imagesList.add (imageUrl);
                                    System.out.println ( imagesList );

                                        ImageAdapter imageAdapter = new ImageAdapter (getActivity (), imagesList);
                                       simpleImageGrid.setAdapter(imageAdapter);


                                    } }
                            }
                        }
                    });
        }
    }
}


