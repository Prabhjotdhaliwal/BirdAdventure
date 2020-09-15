package com.example.birdsadventure;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

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

public class UploadAudioFragment extends Fragment implements View.OnClickListener {

    public static final int RECORD_AUDIO = 200;
    public static final int REQUEST_VIDEO_CAPTURE = 102;

    private Button btnAudioPlay, btnAudioRecord, btnAudioStop;

    private static MediaRecorder mediaRecorder;
    private static MediaPlayer mediaPlayer;

    String userID;
    private String audioFilePath;
    private boolean isRecording;
    private StorageReference storageReference;

    FirebaseFirestore db;
    SharedPreferences sp;

    public UploadAudioFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_upload_audio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = FirebaseFirestore.getInstance();

        isRecording = false;

        storageReference = FirebaseStorage.getInstance().getReference();
        //storageReference = FirebaseStorage.getInstance().getReference("uploads");

        btnAudioPlay = getActivity().findViewById(R.id.btnAudioPlay);
        btnAudioRecord = getActivity().findViewById(R.id.btnAudioRecord);
        btnAudioStop = getActivity().findViewById(R.id.btnAudioStop);

        btnAudioPlay.setOnClickListener(this);
        btnAudioRecord.setOnClickListener(this);
        btnAudioStop.setOnClickListener(this);

        if (!hasMicrophone()) {
            btnAudioStop.setEnabled(false);
            btnAudioPlay.setEnabled(false);
            btnAudioRecord.setEnabled(false);
        } else {
            btnAudioStop.setEnabled(false);
            btnAudioPlay.setEnabled(false);
        }

        File audioFile = null;
        try {
            audioFile = createAudioFile();
        } catch (IOException ex) {
            Toast.makeText(getActivity().getApplicationContext(), "Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

        sp = getActivity().getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
        userID = sp.getString(MyVariables.keyUserDocID, MyVariables.defaultUserDocID);
    }

    private boolean hasMicrophone() {
        PackageManager packageManager = getActivity().getPackageManager();
        return packageManager.hasSystemFeature(PackageManager.FEATURE_MICROPHONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAudioStop:
                btnStopAudioClick(v);
                break;
            case R.id.btnAudioRecord:
                askRecordAudioPermission();
                break;
            case R.id.btnAudioPlay:
                btnPlayAudioClick(v);
            default:
                break;
        }
    }

    private void btnRecordAudioClick() {
        isRecording = true;
        btnAudioStop.setEnabled(true);
        btnAudioPlay.setEnabled(false);
        btnAudioRecord.setEnabled(false);

        Toast.makeText(getActivity().getApplicationContext(), "Recording started", Toast.LENGTH_SHORT).show();

        try {
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setOutputFile(audioFilePath);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.prepare();

            mediaRecorder.start();
        } catch (Exception e) {
            Toast.makeText(getActivity().getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }

    private void btnStopAudioClick(View v) {
        btnAudioStop.setEnabled(false);
        btnAudioPlay.setEnabled(true);

        if (isRecording) {
            btnAudioRecord.setEnabled(false);
            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder = null;
            isRecording = false;

            uploadVideoToFirebase();
        } else {
            mediaPlayer.release();
            mediaPlayer = null;
            btnAudioRecord.setEnabled(true);
        }
    }

    private void btnPlayAudioClick(View v) {
        btnAudioPlay.setEnabled(false);
        btnAudioRecord.setEnabled(false);
        btnAudioStop.setEnabled(true);

        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(audioFilePath);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            Toast.makeText(getActivity().getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void askRecordAudioPermission() {

        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.RECORD_AUDIO}, RECORD_AUDIO);
        } else {
            btnRecordAudioClick();
        }
    }

    private File createAudioFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String audioFileName = "AUDIO_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_MUSIC);

        //   File storageDir=Environment.getExternalStoragePublicDirectory (Environment.DIRECTORY_PICTURES);
        // (it will work for actual device)
        //  final File storageDir =     Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        File audioFile = File.createTempFile(
                audioFileName,  /* prefix */
                ".3gp",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        audioFilePath = audioFile.getAbsolutePath();
        return audioFile;
    }

    private void uploadVideoToFirebase() {

        File f = new File(audioFilePath);

        String name = f.getName();
        Uri contentUri = Uri.fromFile(f);

        final StorageReference audioStorage = storageReference.child("audio/audio" + name);
        audioStorage.putFile(contentUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                audioStorage.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Log.d("tag", "onSuccess: Upload Audio URI is " + uri);
                        userCollectionUploadMediaUrl(uri);
                    }
                });
//                Toast.makeText(getActivity(), "Audio is uploaded", Toast.LENGTH_LONG).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Audio upload failed - " + e.getMessage(), Toast.LENGTH_LONG).show();
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
            media.is_video = false;
            media.is_sound_clip = true;
            media.title = formattedDate;
            media.url = uri.toString();

            db.collection("Users").document(userID).collection("Media").add(media)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {

                            Toast.makeText(getActivity().getApplicationContext(), "Audio is Uploaded", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity().getApplicationContext(), "Audio could not be saved in User Media", Toast.LENGTH_LONG).show();
                        }
                    });
        }
    }

}