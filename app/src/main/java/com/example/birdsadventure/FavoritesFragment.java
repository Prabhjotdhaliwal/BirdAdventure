package com.example.birdsadventure;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
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

public class FavoritesFragment extends Fragment implements View.OnClickListener {

    EditText txtSearchBird;
    Button btnSearch;
    TextView txt_no_favorites;

    FirebaseFirestore db;
    FirebaseUser user;
    String userID;
    private ArrayList<Bird> birdsList;

    private NavController navController;

    public FavoritesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = FirebaseFirestore.getInstance();

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        txt_no_favorites = getActivity().findViewById(R.id.txt_no_favorites);
        txtSearchBird = getActivity().findViewById(R.id.text_search_favorites);
        btnSearch = getActivity().findViewById(R.id.button_search_favorites);
        txt_no_favorites.setText("");

        btnSearch.setOnClickListener(this);

        getUserDetails();

        getFavoriteBirds("");
    }

    private void getUserDetails() {
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            String email = user.getEmail();

            db.collection("Users").whereEqualTo("email", email).get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                QuerySnapshot documents = task.getResult();
                                if (documents.getDocuments().size() > 0) {
                                    userID = documents.getDocuments().get(0).getId();

                                    getFavoriteBirds("");
                                }
                            }
                        }
                    });
        }
    }

    private void getFavoriteBirds(final String searchText) {

        birdsList = new ArrayList<Bird>();
        Query query = db.collection("favorite_birds").whereEqualTo("user_id", userID)
                .whereEqualTo("is_favorite", true);

        query.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            QuerySnapshot querySnapshot = task.getResult();

                            for (QueryDocumentSnapshot document : querySnapshot) {

                                final String birdName = document.getString("bird_name");

                                if (birdName.contains(searchText)) {
                                    String birdID = document.getString("bird_id");

                                    String birdImageURL = document.getString("default_image");
                                    birdsList.add(new Bird(birdID, birdName, birdImageURL));
                                }
                            }
                            if (birdsList.size() > 0) {
                                txt_no_favorites.setText("");
                            } else {
                                if (querySnapshot.getDocuments().size() > 0) {
                                    txt_no_favorites.setText("No birds found matching this Search Criteria.");
                                } else {
                                    txt_no_favorites.setText("\tNo Birds have been added to favorites.\n\tAdd Birds to your favorites from\n\tBird's Profile page.");
                                }
                            }
                            fillRecyclerView();
                        } else {
                            Log.d("tag", "Error getting birds: ", task.getException());
                            Toast.makeText(getActivity().getApplicationContext(), "Error getting birds: " + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_search_favorites) {
            btnSearchClick(v);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        RecyclerView recyclerView = getActivity().findViewById(R.id.recycler_view_search_birds);
        RecyclerView.LayoutManager recyclerLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        BirdsRecyclerAdapter recyclerAdapter = new BirdsRecyclerAdapter(new ArrayList<Bird>(), true);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        getFavoriteBirds("");
    }

    private void btnSearchClick(View v) {

        String searchText = txtSearchBird.getText().toString();
        getFavoriteBirds(searchText);
    }

    private void fillRecyclerView() {

        RecyclerView recyclerView = getActivity().findViewById(R.id.recycler_view_search_birds);
        RecyclerView.LayoutManager recyclerLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        BirdsRecyclerAdapter recyclerAdapter = new BirdsRecyclerAdapter(birdsList, true);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

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

