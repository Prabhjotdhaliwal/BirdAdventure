package com.example.birdsadventure;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FirebaseAuth firebaseAuth;

    public NavController navController;
    public BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firebaseAuth = FirebaseAuth.getInstance();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //bottomNavigation.setOnNavigationItemSelectedListener(navigationListener);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);

//        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.profile:
                Toast.makeText(getApplicationContext(), "User Profile Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.featured_bird:
                Toast.makeText(getApplicationContext(), "Featured_bird Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.news:
                Toast.makeText(getApplicationContext(), "News Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.settings:
                Toast.makeText(getApplicationContext(), "Settings Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.notifications:
                Toast.makeText(getApplicationContext(), "Notifications Selected ", Toast.LENGTH_LONG).show();
                return true;
            case R.id.logout:
                logout();
                return true;
            default:
                return false;
        }
    }

    private void logout() {

        FirebaseAuth.getInstance().signOut();

        SharedPreferences sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(MyVariables.keyLoginAuth, false);
        editor.putString(MyVariables.keyUserID, "");
        editor.apply();

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}

//
//
//    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            Fragment selectedFragment = null;
//            switch (item.getItemId()) {
//                case R.id.home:
//                    selectedFragment = new HomeFragment();
//                    break;
//                case R.id.search:
//                    selectedFragment = new SearchFragment();
//                    break;
//                case R.id.upload:
//                    selectedFragment = new UploadFragment();
//                    break;
////                case R.id.favorite:
////                    selectedFragment = new FavoritesFragment();
////                    break;
////                case R.id.library:
////                    selectedFragment = new LibraryFragment();
////                    break;
//            }
////            getSupportFragmentManager().beginTransaction().replace(R.id.frame_space, selectedFragment).commit();
//            return true;
//        }
//    };
