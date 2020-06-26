package com.example.birdsadventure;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.birdsadventure.ui.main.SectionsPagerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class BirdProfileActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtBirdName;
    ImageView birdImage;
    Button btnFavorites;

    FirebaseUser user;
    FirebaseFirestore db;
    String favoriteDocID;
    String userID;
    String birdID;
    boolean isDocumentExists;
    boolean isFavorite;

    SectionsPagerAdapter sectionsPagerAdapter;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_profile);

        db = FirebaseFirestore.getInstance();

        isFavorite = false;
        isDocumentExists = false;

        birdID = getIntent().getStringExtra("birdID");
        String birdName = getIntent().getStringExtra("birdName");
        String birdImageUrl = getIntent().getStringExtra("birdImageUrl");

        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
        editor = sp.edit();
        editor.putString(MyVariables.keyBirdID, birdID);
        editor.apply();

        txtBirdName = findViewById(R.id.bird_profile_name);
        birdImage = findViewById(R.id.bird_default_profile_image);
        btnFavorites = findViewById(R.id.btn_add_to_favorites);

        btnFavorites.setOnClickListener(this);

        sectionsPagerAdapter = new SectionsPagerAdapter(getApplicationContext(), getSupportFragmentManager());

        txtBirdName.setText(birdName);
        Picasso.get().load(birdImageUrl).into(birdImage);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        getUserDetails();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add_to_favorites) {
            btnFavoritesClick();
        }
    }

    private void btnFavoritesClick() {

        if (isDocumentExists && favoriteDocID != null) {

            db.collection("favorite_birds").document(favoriteDocID).update(
                    "is_favorite", !isFavorite
            ).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        isFavorite = !isFavorite;

                        if (isFavorite) {
                            Toast.makeText(getApplicationContext(), "Bird Added to Favorites", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Bird Removed from Favorites", Toast.LENGTH_SHORT).show();
                        }
                        setFavoriteBtnText();
                    } else {
                        Toast.makeText(getApplicationContext(), "Add/Remove to Favorites Failed!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {


            if (birdID != null) {

                db.collection("Birds").document(birdID).get()
                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {

                                    DocumentSnapshot document = task.getResult();

                                    if (document.exists()) {
                                        String name = document.getString("name");
                                        String region = document.getString("Location_name");
                                        String birdImageUrl = document.getString("birdimgUrl");

                                        Map<String, Object> docData = new HashMap<>();
                                        docData.put("Region", region);
                                        docData.put("bird_id", birdID);
                                        docData.put("bird_name", name);
                                        docData.put("default_image", birdImageUrl);
                                        docData.put("is_favorite", true);
                                        docData.put("user_id", userID);

//                                        db.collection("favorite_birds").document().set(docData)
                                        db.collection("favorite_birds").add(docData)
                                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                                    @Override
                                                    public void onSuccess(DocumentReference documentReference) {

                                                        isDocumentExists = true;
                                                        isFavorite = true;
                                                        favoriteDocID = documentReference.getId();
                                                        Toast.makeText(getApplicationContext(), "Bird Added to Favorites", Toast.LENGTH_SHORT).show();

                                                        setFavoriteBtnText();
                                                    }
                                                })
                                                .addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {

                                                        Toast.makeText(getApplicationContext(), "Add to Favorites Failed!!", Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                    }

                                }
                            }
                        });
            }
        }
    }

    private void getUserDetails() {
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            String email = user.getEmail();

            db.collection("Users").whereEqualTo("email", email)
                    .whereEqualTo("status", true).get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                QuerySnapshot documents = task.getResult();
                                if (documents.getDocuments().size() > 0) {
                                    userID = documents.getDocuments().get(0).getId();

                                    db.collection("favorite_birds").whereEqualTo("user_id", userID)
                                            .whereEqualTo("bird_id", birdID).get()
                                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                                @Override
                                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                    if (task.isSuccessful()) {
                                                        QuerySnapshot documents = task.getResult();
                                                        if (documents.getDocuments().size() > 0) {

                                                            isDocumentExists = true;
                                                            favoriteDocID = documents.getDocuments().get(0).getId();
                                                            isFavorite = documents.getDocuments().get(0).getBoolean("is_favorite");
                                                        } else {
                                                            isDocumentExists = false;
                                                        }
                                                        setFavoriteBtnText();
                                                    }
                                                }
                                            });
                                }
                            }
                        }
                    });
        }
    }

    private void setFavoriteBtnText() {

        if (isFavorite) {

            btnFavorites.setText(R.string.remove_from_favorites);
        } else {
            btnFavorites.setText(R.string.add_to_favorites);
        }
    }
}