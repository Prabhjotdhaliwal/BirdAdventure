package com.example.birdsadventure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    Button btnSignUpHome, btnLoginHome,playVideoSample,playSoundSample;
    TextView birdNameSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        birdNameSample = findViewById(R.id.birdnametxt);
        btnLoginHome = findViewById(R.id.btnLoginHome);
        btnSignUpHome = findViewById(R.id.btnSignUpHome);
        playVideoSample=findViewById (R.id.playVideoSample);
        playSoundSample=findViewById (R.id.playSoundSample);


        btnLoginHome.setOnClickListener(this);
        btnSignUpHome.setOnClickListener(this);
       playVideoSample.setOnClickListener (this);
       playSoundSample.setOnClickListener (this);

        String birdName = "NAME OF THE BIRD";
        birdNameSample.setText(birdName);
    }

    public  void videobtnAction()
    {
        Toast.makeText (MainActivity.this,"Videos",Toast.LENGTH_LONG).show ();
    }
    public  void soundbtnAction()
    {
        Toast.makeText (MainActivity.this,"Sounds",Toast.LENGTH_LONG).show ();
    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.btnLoginHome:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;
            case R.id.btnSignUpHome:
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
                break;
            case R.id.playVideoSample:
               videobtnAction ();
               break;
            case R.id.playSoundSample:
               soundbtnAction ();
              break;
            default:
                break;

        }
    }
}
