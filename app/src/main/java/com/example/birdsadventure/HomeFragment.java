package com.example.birdsadventure;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class HomeFragment extends Fragment implements View.OnClickListener {

    TextView txtUserName, txt_featured_birds_home;
    Button btnUpload, btnLibrary;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = FirebaseFirestore.getInstance();

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        btnUpload = getActivity().findViewById(R.id.btn_upload_home);
        btnLibrary = getActivity().findViewById(R.id.btn_library_home);
        txtUserName = getActivity().findViewById(R.id.user_name);
        txt_featured_birds_home = getActivity().findViewById(R.id.txt_featured_birds_home);

        getUserDetails();

        getFeaturedBirds();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_upload_home) {
            navController.navigate(R.id.uploadFragment);
        } else if (v.getId() == R.id.btn_library_home) {
            navController.navigate(R.id.libraryFragment);
        } else if (v.getId() == R.id.txt_featured_birds_home) {
            navController.navigate(R.id.featuredBirdsFragment);
        }
    }

    private void getUserDetails() {
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            String email = user.getEmail();

            db.collection("Users").whereEqualTo("Email", email).get()
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

    private void fillRecyclerView() {

        recyclerView = getActivity().findViewById(R.id.recycler_featured_birds);
        recyclerLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerAdapter = new BirdsRecyclerAdapter(birdsList, false);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerAdapter.setOnItemClickListener(new BirdsRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Bundle bundle = new Bundle();
                bundle.putParcelable("birds", birdsList.get(position));
                // navController.navigate(R.id.displayFragment, bundle);
                Toast.makeText(getActivity().getApplicationContext(), birdsList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
