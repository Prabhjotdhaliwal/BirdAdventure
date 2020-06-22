package com.example.birdsadventure;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

/**
 * This is HomeFragment page
 */

public class HomeFragment extends Fragment implements View.OnClickListener {

    /**
     * TextView for the user to see
     */
    TextView txtUserName, txt_featured_birds_home;

    FirebaseUser user;
    String userID;

    FirebaseFirestore db;
    private ArrayList<Bird> birdsList;

    private RecyclerView recyclerView;
    private BirdsRecyclerAdapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerLayoutManager;

    private NavController navController;

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * this method  inflater.inflate() you create your View from your XML file.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        db = FirebaseFirestore.getInstance();

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        /**
         * To connect the upload button  and edit text boxes
         * with current activity
         *
         */

        txtUserName = getActivity().findViewById(R.id.user_name);
        txt_featured_birds_home = getActivity().findViewById(R.id.txt_featured_birds_home);

        txt_featured_birds_home.setOnClickListener(this);
        getUserDetails();

        getFeaturedBirds();

    }

    /**
     * This method is for user  to  select  the  buttons of
     * UploadData,MyLibrary, FeaturedBirds on HomeFragment page
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.txt_featured_birds_home) {
            navController.navigate(R.id.featuredBirdsFragment);
        }
    }

    /**
     * Get the Data of the currentUser in shared preferences
     */
    private void getUserDetails() {
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            String email = user.getEmail();
//            Toast.makeText(getActivity().getApplicationContext(), email, Toast.LENGTH_SHORT).show();

            db.collection("Users").whereEqualTo("email", email).get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                QuerySnapshot documents = task.getResult();
                                if (documents.getDocuments().size() > 0) {
                                    userID = documents.getDocuments().get(0).getId();
                                    String name = documents.getDocuments().get(0).getString("name");
                                    txtUserName.setText(name);
                                }
                            }
                        }
                    });
        }
    }

    /**
     * This Method  Query collection is equal to is_featured and value is true then  it show the FeaturedBirds with Name and Url
     * if not it show Error
     */
    private void getFeaturedBirds() {

        birdsList = new ArrayList<Bird>();
        Query query = db.collection("Birds").whereEqualTo("is_Featured", true).limit(8);

        query.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {

                                final String birdName = document.getString("name");
                                String birdImageURL = document.getString("birdimgUrl");
                                birdsList.add(new Bird(birdName, birdImageURL));

                            }
                            fillRecyclerView();
                        } else {
                            Log.d("tag", "Error getting birds: ", task.getException());
                            Toast.makeText(getActivity().getApplicationContext(), "Error getting birds: " + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    /**
     * This Method Show Birds Horizontal in RecyclerView
     */
    private void fillRecyclerView() {

        recyclerView = getActivity().findViewById(R.id.recycler_featured_birds);
        recyclerLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
        recyclerAdapter = new BirdsRecyclerAdapter(birdsList, false);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);
        /**
         * This Method Displays the Selected bird information
         */
        recyclerAdapter.setOnItemClickListener(new BirdsRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                //Bundle bundle = new Bundle();
                //bundle.putParcelable("birds", birdsList.get(position));
                // navController.navigate(R.id.displayFragment, bundle);
                //Toast.makeText(getActivity().getApplicationContext(), birdsList.get(position).getName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), BirdProfileActivity.class);
                intent.putExtra("birdID", birdsList.get(position).getBirdID());
                intent.putExtra("birdName", birdsList.get(position).getName());
                intent.putExtra("birdImageUrl", birdsList.get(position).getImageURL());
                getActivity().startActivity(intent);
            }
        });
    }

}

