package com.example.birdsadventure;

import android.content.Intent;
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


    /**
     * Declaration of Edit Text box for search
     */
    EditText txtSearchDrink;

    /**
     * Declaration of search button
     */
    Button btnSearch;

    /**
     * Declaration of search button
     */
    FirebaseFirestore db;

    /**
     * Array List of birds
     */
    private ArrayList<Bird> birdsList;

    /**
     * It is an container for rendering larger data set of views that can be recycled
     */
    private RecyclerView recyclerView;

    /**
     * To handle the data collection and bind it to the view
     */
    private BirdsRecyclerAdapter recyclerAdapter;

    /**
     * Helps in positioning the items
     */
    private RecyclerView.LayoutManager recyclerLayoutManager;

    /**
     * An object that manages app navigation within a NavHost.
     */
    private NavController navController;

    /**
     * FeaturedBirdsFragment() used to show Featured birds
     */
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

    /**
     * onViewCreated used to render the featured bird list
     * User can also search birds by name and location
     *
     * @param view
     * @param savedInstanceState
     */
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

    /**
     * getFeaturedBirds to fetch only the featured birds from the database
     * and if user search matches with database then fill the recycler view accordingly
     * otherwise there will be an error
     */
    private void getFeaturedBirds(final String searchText) {

        birdsList = new ArrayList<Bird>();
        Query query = db.collection("Birds").whereEqualTo("is_Featured", true);

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

    /**
     * To call btnSearchClick method when clicking on search button
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_search) {
            btnSearchClick(v);
        }
    }

    /**
     * To get featured birds list when user trying to search birds
     *
     * @param v
     */
    private void btnSearchClick(View v) {

        String searchText = txtSearchDrink.getText().toString();
        getFeaturedBirds(searchText);
    }

    /**
     * fillRecyclerView() is used to fill recycler view in featured birds fragment vertically
     */
    private void fillRecyclerView() {

        recyclerView = getActivity().findViewById(R.id.recycler_view_search_birds);
        recyclerLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerAdapter = new BirdsRecyclerAdapter(birdsList, true);
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
