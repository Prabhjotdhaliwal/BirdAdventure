package com.example.birdsadventure;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class SearchFragment extends Fragment implements View.OnClickListener {
    //Database instance
    FirebaseFirestore db;
    EditText txtSearchDrink;
    Button btnSearch;
    Spinner spinnerLocation;
    ArrayList<Location> locationList;

    private ArrayList<Bird> birdsList;

    private NavController navController;

    public SearchFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = FirebaseFirestore.getInstance();

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        txtSearchDrink = getActivity().findViewById(R.id.text_search_place);
        btnSearch = getActivity().findViewById(R.id.button_search);
        spinnerLocation = (Spinner) getActivity().findViewById(R.id.spinner_locations);

        btnSearch.setOnClickListener(this);

        getAllLocations();

        getAllBirds("", "--All Locations--");
    }

    private void getAllLocations() {

        locationList = new ArrayList<Location>();
        locationList.add(new Location("--All Locations--"));

        db.collection("Location")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                locationList.add(new Location(document.get("Location_name").toString()));
                            }

                            ArrayAdapter<Location> locationArrayAdapter = new ArrayAdapter<Location>(getActivity().getApplicationContext(),
                                    android.R.layout.simple_spinner_item, locationList);

                            locationArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                            spinnerLocation.setAdapter(locationArrayAdapter);
                        } else {
                            Log.d("tag", "Error getting Locations: ", task.getException());
                            Toast.makeText(getActivity().getApplicationContext(), "Error getting Locations: " + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    private void getAllBirds(final String searchText, String region) {

        birdsList = new ArrayList<Bird>();
        Query query = null;

        if (region.equals("--All Locations--")) {
            query = db.collection("Birds");
        } else {
            query = db.collection("Birds").whereEqualTo("Location_name", region);
        }

        /*
        if (searchText.equals("")) {
            query = db.collection("Birds");
        } else {

            query = db.collection("Birds").whereGreaterThanOrEqualTo("name", searchText)
                    .whereLessThanOrEqualTo("name", searchText + "\uf8ff");
        }*/

        query.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                final String birdName = document.getString("name");
                                if (birdName.contains(searchText)) {
                                    String birdImageURL = document.getString("birdimgUrl");
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

        Location location = (Location) spinnerLocation.getSelectedItem();

        String searchText = txtSearchDrink.getText().toString();
        getAllBirds(searchText, location.getLocationName());
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

                Bundle bundle = new Bundle();
                bundle.putParcelable("birds", birdsList.get(position));
                // navController.navigate(R.id.displayFragment, bundle);
                Toast.makeText(getActivity().getApplicationContext(), birdsList.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent Intent = new Intent(getActivity(), BirdProfileActivity.class);
                getActivity().startActivity(Intent);
            }
        });
    }
}
