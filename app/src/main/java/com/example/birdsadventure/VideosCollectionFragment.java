package com.example.birdsadventure;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
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


public class VideosCollectionFragment extends Fragment {
    private RecyclerView recyclerView;
    ImageAdapter adapter;
    FirebaseFirestore db;
    StorageReference storageReference;
    private ArrayList<Media> MediaList;
    NavController navController;
    GridView simpleVideoGrid;
    ArrayList<String> videoList;
    private ArrayList<Media> mediaList;
    String imageUrl;
    String audioUrl;
    String videoUrlID;
    String userID;
    FirebaseUser user;

    SharedPreferences sp;
    SharedPreferences.Editor editor;


    //demo data
    int birdPictures[] = {R.drawable.youtube, R.drawable.youtube, R.drawable.youtube, R.drawable.youtube,
            R.drawable.youtube, R.drawable.youtube, R.drawable.youtube, R.drawable.youtube, R.drawable.youtube,
            R.drawable.youtube, R.drawable.youtube, R.drawable.youtube, R.drawable.youtube, R.drawable.youtube};


    public VideosCollectionFragment() {
        // Required empty public constructor
    }

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

        return inflater.inflate(R.layout.fragment_videos_collection, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = FirebaseFirestore.getInstance();
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        simpleVideoGrid = view.findViewById(R.id.simpleGridView1); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        //ImageAdapter imageAdapter = new ImageAdapter (getActivity (), birdPictures);
        // simpleVideoGrid.setAdapter(imageAdapter);

        getUserDetails();

        // implement setOnItemClickListener event on GridView
        simpleVideoGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "bird video selected", Toast.LENGTH_LONG).show();

                //send  selected image info to another actiivity

                Bundle b = new Bundle();
                b.putString("libraryVideo", mediaList.get(position).url);
                b.putString("mediaID", mediaList.get(position).media_id);
                navController.navigate(R.id.videoPlayerFragment);
            }
        });

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


                                    sp = getActivity().getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
                                    editor = sp.edit();
                                    editor.putString(MyVariables.keyUserDocID, userID);
                                    editor.apply();
                                    getuserCollectionMediaUrl();

//
                                }
                            }
                        }
                    });
        }
    }

    private void getuserCollectionMediaUrl() {

        if (userID != null) {

            db.collection("Users").document(userID).collection("Media")
                    .whereEqualTo("is_deleted", false).whereEqualTo("is_video", true).get().
                    addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {

                                //list of video urls
                                videoList = new ArrayList<>();
                                mediaList = new ArrayList<Media>();
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    videoUrlID = document.getString("url");
                                    String mediaID = document.getId();
                                    //Media media = new Media(videoUrlID, false, true, false, false);

                                    videoList.add(videoUrlID);
                                    mediaList.add(new Media("", videoUrlID, mediaID));
                                    //System.out.println(videoUrlID);

                                }

                                /**
                                 * Write here the code to get the list and display the videos, or thumbnails.
                                 * Or just show dummy thumbnails for videoList.size() times.
                                 */
                            }
                        }
                    });
        }
    }
}


