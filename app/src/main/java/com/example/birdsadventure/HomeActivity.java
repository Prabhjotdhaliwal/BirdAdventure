package com.example.birdsadventure;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomnavigation = findViewById(R.id.bottom_navigation);
    bottomnavigation.setOnNavigationItemSelectedListener(navigationListener);
    }
 private BottomNavigationView.OnNavigationItemSelectedListener navigationListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
     @Override
     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
         Fragment selectedFragment = null ;
         switch (item.getItemId()){
             case R.id.home:
                 selectedFragment = new HomeFragment();
                 break;
             case R.id.search:
                 selectedFragment = new SearchFragment();
                 break;
             case R.id.upload:
                 selectedFragment = new UploadFragment();
                 break;
             case R.id.favorite:
                 selectedFragment = new FavoritesFragment();
                 break;
             case R.id.library:
                 selectedFragment = new LibraryFragment();
                 break;
         }
getSupportFragmentManager().beginTransaction().replace(R.id.frame_space, selectedFragment).commit();
         return true;
     }
 };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
