package com.example.birdsadventure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSignUpHome, btnLoginHome, btnGuest;
    TextView birdNameSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        birdNameSample = findViewById(R.id.birdNameSample);
        btnLoginHome = findViewById(R.id.btnLoginHome);
        btnSignUpHome = findViewById(R.id.btnSignUpHome);
        btnGuest = findViewById(R.id.btnGuest);

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
            case R.id.btnGuest:
                startActivity(new Intent(getApplicationContext(), GuestHome.class));
                Toast.makeText(this, "Welcoming you to the Guest space", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }
    }
}
