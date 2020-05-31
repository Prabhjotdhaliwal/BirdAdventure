package com.example.birdsadventure;

import android.os.Bundle;
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

import java.util.ArrayList;

public class SearchFragment extends Fragment implements View.OnClickListener {

    EditText txtSearchDrink;
    Button btnSearch;

    private ArrayList<Bird> birdsList;

    private RecyclerView recyclerView;
    private BirdsRecyclerAdapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerLayoutManager;

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

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        txtSearchDrink = getActivity().findViewById(R.id.text_search_place);
        btnSearch = getActivity().findViewById(R.id.button_search);

        btnSearch.setOnClickListener(this);

        getAllBirds();
        fillRecyclerView();
    }

    private void getAllBirds() {
        /**
         TODO: get data from FireStore
         */

        //sample data temporarily added
        birdsList = new ArrayList<Bird>();
        birdsList.add(new Bird("Parrot", "https://pyxis.nymag.com/v1/imgs/a40/333/c115e400743744250195e8c5e8cfc9abc9-9-parrots.rsquare.w700.jpg"));
        birdsList.add(new Bird("Sparrow", "https://www.allaboutbirds.org/guide/assets/photo/63742431-480px.jpg"));
        birdsList.add(new Bird("Pigeon", "https://www.allaboutbirds.org/guide/assets/photo/66031271-480px.jpg"));
        birdsList.add(new Bird("Ostrich", "https://cdn.mos.cms.futurecdn.net/tMnjLRtEm47ueTPt9Rkyxd-320-80.jpg"));

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_search) {
            btnSearchClick(v);
        }
    }

    private void btnSearchClick(View v) {

        String searchedText = txtSearchDrink.getText().toString();
        getAllBirds();
        fillRecyclerView();
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
