package com.example.birdsadventure;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSignUpHome, btnLoginHome, playVideoSample, playSoundSample;
    TextView birdNameSample;

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    boolean isLogin;
    String currentUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (validateAutomaticLogin()) {
            navigateToHome();
        }

//        birdNameSample = findViewById(R.id.txtBirdName);
        btnLoginHome = findViewById(R.id.btnLoginHome);
        btnSignUpHome = findViewById(R.id.btnSignUpHome);
//        playVideoSample = findViewById(R.id.playVideoSample);
//        playSoundSample = findViewById(R.id.playSoundSample);

        btnLoginHome.setOnClickListener(this);
        btnSignUpHome.setOnClickListener(this);
        playVideoSample.setOnClickListener(this);
        playSoundSample.setOnClickListener(this);

        String birdName = "NAME OF THE BIRD";
        birdNameSample.setText(birdName);
    }

    private boolean validateAutomaticLogin() {
        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);

        isLogin = sp.getBoolean(MyVariables.keyLoginAuth, MyVariables.defaultLoginAuth);
        currentUserID = sp.getString(MyVariables.keyUserID, MyVariables.defaultUserID);

        if (isLogin && !currentUserID.equals("")) {
            return true;
        }
        return false;
    }

    private void navigateToHome() {
        finish();
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLoginHome:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;
            case R.id.btnSignUpHome:
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
                break;
//            case R.id.playVideoSample:
//                btnVideoClick();
//                break;
//            case R.id.playSoundSample:
//                btnSoundClick();
//                break;
            default:
                break;

        }
    }

    public void btnVideoClick() {
        Toast.makeText(MainActivity.this, "Videos", Toast.LENGTH_LONG).show();
    }

    public void btnSoundClick() {
        Toast.makeText(MainActivity.this, "Sounds", Toast.LENGTH_LONG).show();
    }

}
