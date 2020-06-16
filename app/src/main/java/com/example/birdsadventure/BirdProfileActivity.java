package com.example.birdsadventure;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.birdsadventure.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

public class BirdProfileActivity extends AppCompatActivity {

    String birdID;
    TextView txtBirdName;
    ImageView birdImage;

    SectionsPagerAdapter sectionsPagerAdapter;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_profile);

        birdID = getIntent().getStringExtra("birdID");
        String birdName = getIntent().getStringExtra("birdName");
        String birdImageUrl = getIntent().getStringExtra("birdImageUrl");

        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
        editor = sp.edit();
        editor.putString(MyVariables.keyBirdID, birdID);
        editor.apply();

        txtBirdName = findViewById(R.id.bird_profile_name);
        birdImage = findViewById(R.id.bird_default_profile_image);

        sectionsPagerAdapter = new SectionsPagerAdapter(getApplicationContext(), getSupportFragmentManager());

        txtBirdName.setText(birdName);
        Picasso.get().load(birdImageUrl).into(birdImage);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

}