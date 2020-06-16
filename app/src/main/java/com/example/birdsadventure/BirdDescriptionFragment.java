package com.example.birdsadventure;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class BirdDescriptionFragment extends Fragment {

    TextView txtDescription, txtCity, txtRegion, txtBiome, txtHabitat, txtDiet, txtColor, txtHeight, txtWeight;

    String birdID;
    Bird currentBird;
    FirebaseFirestore db;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    public BirdDescriptionFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bird_description, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = FirebaseFirestore.getInstance();

        txtDescription = view.findViewById(R.id.bird_desc_description);
        txtCity = view.findViewById(R.id.bird_desc_city);
        txtRegion = view.findViewById(R.id.bird_desc_region);
        txtBiome = view.findViewById(R.id.bird_desc_biome);
        txtHabitat = view.findViewById(R.id.bird_desc_habitat);
        txtDiet = view.findViewById(R.id.bird_desc_diet);
        txtColor = view.findViewById(R.id.bird_desc_colour);
        txtHeight = view.findViewById(R.id.bird_desc_height);
        txtWeight = view.findViewById(R.id.bird_desc_weight);

        sp = getActivity().getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
        birdID = sp.getString(MyVariables.keyBirdID, MyVariables.defaultBirdID);

        getBirdDetails();

    }

    private void getBirdDetails() {
        currentBird = new Bird();

        if (birdID != null) {

            if (birdID.equals("")) {
                Toast.makeText(getActivity().getApplicationContext(), "Bird Data not found", Toast.LENGTH_SHORT).show();
                return;
            }

            db.collection("Birds").document(birdID).get()
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {

                                DocumentSnapshot document = task.getResult();

                                if (document.exists()) {
                                    String name = document.getString("name");
                                    String biome = document.getString("Biome");
                                    String color = document.getString("Colour");
                                    String description = document.getString("Description");
                                    String diet = document.getString("Diet");
                                    String habitat = document.getString("Habitat");
                                    String height = document.getString("Height");
                                    String region = document.getString("Location_name");
                                    String city = document.getString("Region");
                                    String weight = document.getString("Weight");
                                    String birdImageUrl = document.getString("birdimgUrl");

                                    currentBird = new Bird(birdID, name, birdImageUrl, biome, color, description, diet,
                                            habitat, height, region, city, weight);

                                    txtDescription.setText(description);
                                    txtCity.setText(city);
                                    txtRegion.setText(region);
                                    txtBiome.setText(biome);
                                    txtHabitat.setText(habitat);
                                    txtDiet.setText(diet);
                                    txtColor.setText(color);
                                    txtHeight.setText(height);
                                    txtWeight.setText(weight);

                                }

                            }
                        }
                    });
        }
    }
}