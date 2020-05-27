package com.example.birdsadventure;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.service.media.MediaBrowserService;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class UploadFragment extends Fragment {
    public static final int CAMERA_CODE = 007;
    public static final int CAMERA_REQUEST = 006;

    ImageView imageView;
    Button camerabtn , gallerybtn;

    public UploadFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_upload, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = getActivity().findViewById(R.id.imageView);
        camerabtn = getActivity().findViewById(R.id.cameraBtn);
        gallerybtn = getActivity().findViewById(R.id.galleryBtn);

        camerabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askcamerapermission();
            }
        });
    }
    private void askcamerapermission() {
        if(ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {

            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA},CAMERA_CODE);
        } else {
            opencamera();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == CAMERA_CODE){
            if(grantResults.length < 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                opencamera();
            } else {

                Toast.makeText(getActivity().getApplicationContext(), "Camera permissions are needed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void opencamera() {
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera, CAMERA_REQUEST);
        Toast.makeText(getActivity().getApplicationContext(), "opening camera", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == CAMERA_REQUEST){
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(image);
        }

    }
}
