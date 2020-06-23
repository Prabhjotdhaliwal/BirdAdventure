package com.example.birdsadventure;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;


public class BirdLocationFragment extends Fragment {

    FirebaseFirestore db;
    SupportMapFragment mapFragment;
    SharedPreferences sp;

    public BirdLocationFragment() { }


    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bird_location, container, false);
        mapFragment = null;

        db = FirebaseFirestore.getInstance();

        //getBirdDetails();

        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {


                    LatLng latLng = new LatLng(1.289545, 103.849972);
                    googleMap.addMarker(new MarkerOptions().position(latLng)
                            .title("Singapore"));

                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18.0f));
                }
            });
        }

        // R.id.map is a FrameLayout, not a Fragment
        getChildFragmentManager().beginTransaction().replace(R.id.map_View, mapFragment).commit();

        return rootView;
    }

    private void getBirdDetails() {

        sp = getActivity().getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
        String birdID = sp.getString(MyVariables.keyBirdID, MyVariables.defaultBirdID);

        if (birdID != null) {

            if (birdID.equals("")) {
                Toast.makeText(getActivity().getApplicationContext(), "Bird Data not found", Toast.LENGTH_SHORT).show();
                return;
            }

            db.collection("Birds").document(birdID).collection("media")
                    .whereEqualTo("is_deleted", false).get().
                    addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {

                            }
                        }
                    });
        }
    }

}



