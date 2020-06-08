package com.example.birdsadventure;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class UploadVideoFragment extends Fragment  implements View.OnClickListener {

    public static final int CAMERA_CODE = 101;
    public static final int REQUEST_VIDEO_CAPTURE = 102;
    public static final int GALLERY_REQUEST_CODE = 105;

    Button btnCameraVideo, btnGalleryVideo;
    VideoView videoViewCamera;

    String currentVideoPath;
    StorageReference storageReference;

    public UploadVideoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_upload_video, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        storageReference = FirebaseStorage.getInstance().getReference();
        //storageReference = FirebaseStorage.getInstance().getReference("uploads");

        videoViewCamera = getActivity().findViewById(R.id.videoViewCamera);
        btnCameraVideo = getActivity().findViewById(R.id.btnCameraVideo);
        btnGalleryVideo = getActivity().findViewById(R.id.btnGalleryVideo);

        btnCameraVideo.setOnClickListener(this);
        btnGalleryVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCameraVideo:
                askCameraPermission();
                break;
            case R.id.btnGalleryVideo:
                Intent intentGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentGallery, GALLERY_REQUEST_CODE);
                break;
            default:
                break;
        }
    }

    //ask user to grant camera access permissions
    private void askCameraPermission() {

        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getActivity().getApplicationContext(), "permissions.", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, CAMERA_CODE);
        } else {
            dispatchTakeVideoIntent();
        }
    }

    //check user's permissions to access camera
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CAMERA_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                dispatchTakeVideoIntent();
            } else {
                Toast.makeText(getActivity().getApplicationContext(), "Camera permissions are required!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void dispatchTakeVideoIntent() {
        Toast.makeText(getActivity().getApplicationContext(), "hi there,", Toast.LENGTH_SHORT).show();
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        takeVideoIntent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
        takeVideoIntent.putExtra(MediaStore.EXTRA_DURATION_LIMIT,8);
        if (takeVideoIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            Toast.makeText(getActivity().getApplicationContext(), "yes there,", Toast.LENGTH_SHORT).show();
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
        else {

            Toast.makeText(getActivity().getApplicationContext(), "no there,", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == Activity.RESULT_OK) {

            Toast.makeText(getActivity().getApplicationContext(), "hellozzzz ", Toast.LENGTH_SHORT).show();
            Uri videoUri = intent.getData();
            videoViewCamera.setVideoURI(videoUri);
            videoViewCamera.start();
        }
    }
}