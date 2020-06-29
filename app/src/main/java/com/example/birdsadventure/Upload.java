package com.example.birdsadventure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * This is upload page
 * where user upload images and see galleery
 */

public class Upload extends AppCompatActivity {
    public static final int CAMERA_CODE = 007;
    ImageView imageView;
    Button camerabtn , gallerybtn;

    /**
     * To set the layout of the activity from which it is invoked
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_upload);

//        imageView = findViewById(R.id.imageView);
//        camerabtn = findViewById(R.id.cameraBtn);
//        gallerybtn = findViewById(R.id.galleryBtn);
//
//        Toast.makeText(this, "hello, I am here!!!!!!!", Toast.LENGTH_SHORT).show();
//
//        camerabtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(Upload.this, "camera button is clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
//
//    private void askcamerapermission() {
//        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
//        {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_CODE);
//        } else {
//            opencamera();
//        }
//    }
//
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if(requestCode == CAMERA_CODE){
//            if(grantResults.length < 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                opencamera();
//            } else {
//                Toast.makeText(this, "Camera permissions are needed", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    private void opencamera() {
//        Toast.makeText(this, "opening camera", Toast.LENGTH_SHORT).show();
//    }
}
