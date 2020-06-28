package com.example.birdsadventure;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class NotificationBirdsFragment extends Fragment {

    FirebaseFirestore db;

    TextView notification_location_name;
    String locationID;

    private ArrayList<Bird> birdsList;

    public NotificationBirdsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notification_birds, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = FirebaseFirestore.getInstance();

        locationID = getArguments().getString("locationID");
        String region = getArguments().getString("region");

        notification_location_name = getActivity().findViewById(R.id.notification_location_name);
        notification_location_name.setText(region);

        getAllBirds();
    }

    private void getAllBirds() {

        birdsList = new ArrayList<Bird>();

        db.collection("Bird_Location").whereEqualTo("location_id", locationID)
                .whereEqualTo("is_valid", true).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            QuerySnapshot querySnapshot = task.getResult();

                            for (QueryDocumentSnapshot document : querySnapshot) {

                                final String birdName = document.getString("bird_name");
                                String birdID = document.getString("bird_id");
                                String birdImageURL = document.getString("bird_image");
                                birdsList.add(new Bird(birdID, birdName, birdImageURL));
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

        RecyclerView recyclerView = getActivity().findViewById(R.id.recycler_view_search_birds);
        RecyclerView.LayoutManager recyclerLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        BirdsRecyclerAdapter recyclerAdapter = new BirdsRecyclerAdapter(birdsList, true);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerAdapter.setOnItemClickListener(new BirdsRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Intent intent = new Intent(getActivity(), BirdProfileActivity.class);
                intent.putExtra("birdID", birdsList.get(position).getBirdID());
                intent.putExtra("birdName", birdsList.get(position).getName());
                intent.putExtra("birdImageUrl", birdsList.get(position).getImageURL());
                getActivity().startActivity(intent);
            }
        });
    }
}