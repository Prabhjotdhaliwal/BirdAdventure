package com.example.birdsadventure;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

/**
 * The Home Activity for the Application
 * This is the first screen user see after login
 */

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    /**
     *  Declaration of firebase authentication to get backend services
     */
    FirebaseAuth firebaseAuth;
    Toolbar toolbar;
    public NavController navController;
    public BottomNavigationView bottomNavigationView;
    /**
     * SharedPreferences Object
     */
    SharedPreferences sp;
    SharedPreferences.Editor editor;             /** This Interface used for modifying values in a SharedPreferences object */
    boolean isLogin;                           /** To check if user is already logged in or not */
    String currentUserID;                         /** Returns the ID of the current user if they are logged in */

    /**
     *  To set the layout of the activity from which it is invoked.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //
        Toolbar toolbar = findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
        //

        if (!validateAutomaticLogin()) {
            goToHomeScreen();
        }

        firebaseAuth = FirebaseAuth.getInstance();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //bottomNavigation.setOnNavigationItemSelectedListener(navigationListener);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);

//        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    /**
     *  To check if the user is already log in
     * @return
     */
    private boolean validateAutomaticLogin() {
        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);

        isLogin = sp.getBoolean(MyVariables.keyLoginAuth, MyVariables.defaultLoginAuth);
        currentUserID = sp.getString(MyVariables.keyUserID, MyVariables.defaultUserID);

        if (isLogin && !currentUserID.equals("")) {
            return true;
        }
        return false;
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * This Method  gets called when user select an options  such as( Profile,FeaturedBirds,News,Settings,Favourites and logout)
     * @param item a MenuItem Selected
     * @return the selected Item
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.profile:
                navController.navigate(R.id.profileFragment);
                return true;
            case R.id.featured_bird:
                navController.navigate(R.id.featuredBirdsFragment);
                return true;
            case R.id.news:
                navController.navigate(R.id.newsFragment);
                return true;
            case R.id.settings:
                navController.navigate(R.id.settingsFragment);
                return true;
            case R.id.favourites:
                navController.navigate(R.id.favoritesFragment);
                return true;
            case R.id.logout:
                logout();
                return true;
            default:
                return false;
        }
    }

    /**
     * Method called on Logout from Application
     */
    private void logout() {

        FirebaseAuth.getInstance().signOut();

        SharedPreferences sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(MyVariables.keyLoginAuth, false);
        editor.putString(MyVariables.keyUserID, "");
        editor.apply();

        goToHomeScreen();
    }

    /**
     * @See The HomePage after LoggedOut
     */
    private void goToHomeScreen() {

        finish();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
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
