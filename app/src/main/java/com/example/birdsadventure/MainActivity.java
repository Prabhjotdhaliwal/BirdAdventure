package com.example.birdsadventure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSignUpHome, btnLoginHome;
    TextView birdNameSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        birdNameSample = findViewById(R.id.birdNameSample);
        btnLoginHome = findViewById(R.id.btnLoginHome);
        btnSignUpHome = findViewById(R.id.btnSignUpHome);

        btnLoginHome.setOnClickListener(this);
        btnSignUpHome.setOnClickListener(this);

        String birdName = "NAME OF THE BIRD";
        birdNameSample.setText(birdName);
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
            default:
                break;

        }
    }
}
