package com.example.birdsadventure;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.birdsadventure.ui.main.SectionsPagerAdapter;

public class BirdProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_bird_profile);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter (this, getSupportFragmentManager ());
        ViewPager viewPager = findViewById (R.id.view_pager);
        TextView birdname=findViewById (R.id.birdtitle);//Bird.getname
        viewPager.setAdapter (sectionsPagerAdapter);
        TabLayout tabs = findViewById (R.id.tabs);
        tabs.setupWithViewPager (viewPager);
    }
}