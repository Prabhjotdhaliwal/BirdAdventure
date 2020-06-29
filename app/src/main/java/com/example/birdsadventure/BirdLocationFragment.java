package com.example.birdsadventure;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;


public class BirdLocationFragment extends Fragment {

    FirebaseFirestore db;
    SupportMapFragment mapFragment;
    SharedPreferences sp;

    public BirdLocationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bird_location, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapFragment = null;

        db = FirebaseFirestore.getInstance();

        getBirdDetails();

    }

    private void getBirdDetails() {

        sp = getActivity().getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
        String birdID = sp.getString(MyVariables.keyBirdID, MyVariables.defaultBirdID);

        if (birdID != null) {

            if (birdID.equals("")) {
                Toast.makeText(getActivity().getApplicationContext(), "Bird Data not found", Toast.LENGTH_SHORT).show();
                return;
            }

            db.collection("Bird_Location").whereEqualTo("bird_id", birdID).get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                final QuerySnapshot documents = task.getResult();
                                if (documents.getDocuments().size() > 0) {
                                    final String locationID = documents.getDocuments().get(0).getString("location_id");

                                    db.collection("Location").document(locationID).get()
                                            .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                @Override
                                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                    if (task.isSuccessful()) {
                                                        DocumentSnapshot documentSnapshot = task.getResult();

                                                        String strLatitude = documentSnapshot.getString("latitude");
                                                        String strLongitude = documentSnapshot.getString("longitude");
                                                        final String proximity = documentSnapshot.getString("proximity");
                                                        final String region = documentSnapshot.getString("Location_name");
                                                        final double latitude = Double.parseDouble(strLatitude);
                                                        final double longitude = Double.parseDouble(strLongitude);

                                                        if (mapFragment == null) {
                                                            mapFragment = SupportMapFragment.newInstance();
                                                            mapFragment.getMapAsync(new OnMapReadyCallback() {
                                                                @Override
                                                                public void onMapReady(GoogleMap googleMap) {

                                                                    LatLng latLng = new LatLng(latitude, longitude);
                                                                    googleMap.addMarker(new MarkerOptions().position(latLng).title(region));

                                                                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f));
                                                                }
                                                            });
                                                        }

                                                        // R.id.map is a FrameLayout, not a Fragment
                                                        getChildFragmentManager().beginTransaction().replace(R.id.map_View, mapFragment).commit();

                                                    }
                                                }
                                            });
                                }
                            }
                        }
                    });
        }
    }

}



