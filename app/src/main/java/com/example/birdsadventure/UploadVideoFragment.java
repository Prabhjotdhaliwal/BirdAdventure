package com.example.birdsadventure;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UploadVideoFragment extends Fragment implements View.OnClickListener {

    public static final int CAMERA_CODE = 101;
    public static final int REQUEST_VIDEO_CAPTURE = 102;
    public static final int GALLERY_REQUEST_CODE = 105;

    Button btnCameraVideo, btnGalleryVideo;
    VideoView videoViewCamera;
    TextView txtCaptureAudio;
    MediaController mediaController;

    String userID;
    String currentVideoPath;
    StorageReference storageReference;
    private NavController navController;

    FirebaseFirestore db;
    SharedPreferences sp;

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

        db = FirebaseFirestore.getInstance();

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        storageReference = FirebaseStorage.getInstance().getReference();
        //storageReference = FirebaseStorage.getInstance().getReference("uploads");

        videoViewCamera = getActivity().findViewById(R.id.videoViewCamera);
        btnCameraVideo = getActivity().findViewById(R.id.btnCameraVideo);
        btnGalleryVideo = getActivity().findViewById(R.id.btnGalleryVideo);
        txtCaptureAudio = getActivity().findViewById(R.id.txtCaptureAudio);

        btnCameraVideo.setOnClickListener(this);
        btnGalleryVideo.setOnClickListener(this);
        txtCaptureAudio.setOnClickListener(this);

        videoViewCamera.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                        mediaController = new MediaController(getActivity().getApplicationContext());
                        videoViewCamera.setMediaController(mediaController);
                        mediaController.setAnchorView(videoViewCamera);
                    }
                });
            }
        });

        videoViewCamera.start();

        sp = getActivity().getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
        userID = sp.getString(MyVariables.keyUserDocID, MyVariables.defaultUserDocID);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCameraVideo:
                askCameraPermission();
                break;
            case R.id.btnGalleryVideo:
                Intent intentGallery = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);

                intentGallery.setType("video/*");

                startActivityForResult(intentGallery, GALLERY_REQUEST_CODE);
                break;
            case R.id.txtCaptureAudio:
                navController.navigate(R.id.uploadAudioFragment);
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
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

//        takeVideoIntent.setType("video/*");

        takeVideoIntent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0);
        takeVideoIntent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 5);
        if (takeVideoIntent.resolveActivity(getActivity().getPackageManager()) != null) {

            File videoFile = null;
            try {
                videoFile = createVideoFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }

            if (videoFile != null) {
                Uri videoUri = FileProvider.getUriForFile(getActivity(),
                        "com.example.android.fileprovider",
                        videoFile);
                takeVideoIntent.putExtra(MediaStore.EXTRA_OUTPUT, videoUri);
                startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {

        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == Activity.RESULT_OK) {

            File f = new File(currentVideoPath);

            videoViewCamera.setVideoURI(Uri.fromFile(f));

            //Uri videoUri = intent.getData();
            //videoViewCamera.setVideoURI(videoUri);
            videoViewCamera.start();

            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri contentUri = Uri.fromFile(f);
            mediaScanIntent.setData(contentUri);
            getActivity().sendBroadcast(mediaScanIntent);

            //Upload the captured image to firebase
            uploadVideoToFirebase(f.getName(), contentUri);
        }

        //Gallery
        if (requestCode == GALLERY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Uri contentUri = intent.getData();
                // Uri contentUri= Uri.parse(currentPhotoPath);

                String timeStamp = new SimpleDateFormat("yyyyMMdd_MMmmss").format(new Date());
                String videoFileName = "JPEG_" + timeStamp + "." + getFileExt(contentUri);
                Log.d("tag", "onActivityResult: Gallery Video Uri: " + videoFileName);
                videoViewCamera.setVideoURI(contentUri);

                uploadVideoToFirebase(videoFileName, contentUri);
            }
        }
    }

    private void uploadVideoToFirebase(String name, Uri contentUri) {
        final StorageReference videosStorage = storageReference.child("videos/video" + name);
        videosStorage.putFile(contentUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                videosStorage.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Log.d("tag", "onSuccess: Upload Image URI is " + uri);

                        userCollectionUploadMediaUrl(uri);

//                        videoViewCamera.setVideoURI(uri);
//                        videoViewCamera.requestFocus();
                    }
                });
//                Toast.makeText(getActivity(), "Video is uploaded", Toast.LENGTH_LONG).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Video upload failed - " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void userCollectionUploadMediaUrl(Uri uri) {
        if (userID != null) {


            Calendar c = Calendar.getInstance();
            System.out.println("Current time => "+c.getTime());

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = df.format(c.getTime());
            System.out.println ( formattedDate );


            Media media = new Media();
            media.is_deleted = false;
            media.is_image = false;
            media.is_video = true;
            media.is_sound_clip = false;
            media.title = formattedDate;
            media.url = uri.toString();

            db.collection("Users").document(userID).collection("Media").add(media)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {

                            Toast.makeText(getActivity().getApplicationContext(), "Video is Uploaded", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity().getApplicationContext(), "Video could not be saved in User Media", Toast.LENGTH_LONG).show();
                        }
                    });
        }
    }

    private String getFileExt(Uri contentUri) {
        ContentResolver c = getActivity().getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(c.getType(contentUri));
    }

    private File createVideoFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String videoFileName = "VIDEO_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_MOVIES);

        //   File storageDir=Environment.getExternalStoragePublicDirectory (Environment.DIRECTORY_PICTURES);
        // (it will work for actual device)
        //  final File storageDir =     Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        File videoFile = File.createTempFile(
                videoFileName,
                /* prefix */
                ".mp4",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentVideoPath = videoFile.getAbsolutePath();
        return videoFile;
    }

}