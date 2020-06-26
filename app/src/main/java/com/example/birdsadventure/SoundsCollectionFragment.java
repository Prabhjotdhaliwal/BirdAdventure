package com.example.birdsadventure;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;


public class SoundsCollectionFragment extends Fragment {
    private RecyclerView recyclerView;
    private ImageView imgcollect;
    String imageUrl;
    String audioUrl;
    String videoUrlID;
    String userID;
    User currentUser;
    ArrayList<String> soundList;
    private ArrayList<Media> mediaList;

    FirebaseUser user;
    FirebaseFirestore db;

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    StorageReference storageReference;

    public SoundsCollectionFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerViewsounds;
    List<soundCollections> itemList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_sounds_collection, container, false);

        return view;

    }

    private List<soundCollections> initdata() {

        itemList = new ArrayList<>();
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
        super.onViewCreated(view, savedInstanceState);
        db = FirebaseFirestore.getInstance();
//
        getUserDetails();

        recyclerViewsounds = view.findViewById(R.id.recyler_View_soundscollection);
        recyclerViewsounds.setHasFixedSize(true);
        recyclerViewsounds.setLayoutManager(new LinearLayoutManager(getContext()));
        //initdata();

//        recyclerViewsounds=new soundCollectionAdapter (  );

    }

    private void getUserDetails() {
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            String email = user.getEmail();

            db.collection("Users").whereEqualTo("email", email)
                    .whereEqualTo("status", true).get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                QuerySnapshot documents = task.getResult();
                                if (documents.getDocuments().size() > 0) {
                                    userID = documents.getDocuments().get(0).getId();

                                    getuserCollectionMediaUrl();

                                    sp = getActivity().getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
                                    editor = sp.edit();
                                    editor.putString(MyVariables.keyUserDocID, userID);
                                    editor.apply();


                                }
                            }
                        }
                    });
        }
    }

    private void getuserCollectionMediaUrl() {

        if (userID != null) {

            db.collection("Users").document(userID).collection("Media")
                    .whereEqualTo("is_deleted", false).whereEqualTo("is_sound_clip", true).get().
                    addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {

                                soundList = new ArrayList<>();
                                mediaList = new ArrayList<Media>();
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    audioUrl = document.getString("url");
                                    //Media media = new Media(audioUrl, false, false, true, false);

                                    String mediaID = document.getId();
                                    mediaList.add(new Media("", audioUrl, mediaID));
                                    soundList.add(audioUrl);
                                    //System.out.println(soundList);
                                }

                                /**
                                 * Write here the code to get the list and display the videos, or thumbnails.
                                 * Or just show dummy thumbnails for videoList.size() times.
                                 */

//                                recyclerViewsounds.setAdapter(new soundCollectionAdapter(soundList));

                            }
                        }
                    });
        }
    }
}