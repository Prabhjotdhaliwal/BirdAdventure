package com.example.birdsadventure;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class FeaturedBirdsFragment extends Fragment implements View.OnClickListener {

    EditText txtSearchDrink;
    Button btnSearch;

    FirebaseFirestore db;
    private ArrayList<Bird> birdsList;

    private RecyclerView recyclerView;
    private BirdsRecyclerAdapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerLayoutManager;

    private NavController navController;

    public FeaturedBirdsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_featured_birds, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = FirebaseFirestore.getInstance();

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        txtSearchDrink = getActivity().findViewById(R.id.text_search_place);
        btnSearch = getActivity().findViewById(R.id.button_search);

        btnSearch.setOnClickListener(this);

        getFeaturedBirds("");
    }

    private void getFeaturedBirds(final String searchText) {

        birdsList = new ArrayList<Bird>();
        Query query = db.collection("Birds").whereEqualTo("isFeatured", true);

        query.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {

                                final String birdName = document.getString("name");

                                if (birdName.contains(searchText)) {
                                    String birdImageURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Northern_Cardinal_%28Cardinalis_cardinalis%29_male.jpg/1200px-Northern_Cardinal_%28Cardinalis_cardinalis%29_male.jpg";
                                    birdsList.add(new Bird(birdName, birdImageURL));
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
        if (v.getId() == R.id.button_search) {
            btnSearchClick(v);
        }
    }

    private void btnSearchClick(View v) {

        String searchText = txtSearchDrink.getText().toString();
        getFeaturedBirds(searchText);
    }

    private void fillRecyclerView() {

        recyclerView = getActivity().findViewById(R.id.recycler_view_search_birds);
        recyclerLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerAdapter = new BirdsRecyclerAdapter(birdsList, true);
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
