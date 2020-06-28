package com.example.birdsadventure;

import android.app.ProgressDialog;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class VideoPlayerFragment extends Fragment implements View.OnClickListener {
    VideoView selectedVideo;
    Button saveVideobtn, shareVideobtn;
    ProgressDialog mProgressDialog;
    URL url;
    String mediaID;

    public VideoPlayerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video_player, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        selectedVideo = view.findViewById(R.id.videoViewGallery); // init a ImageView
        saveVideobtn = view.findViewById(R.id.savevideobtn);
        shareVideobtn = view.findViewById(R.id.shareVideobtn);


        //to get data from the parecelable such as img title & Url

        // Media media = getArguments().getParcelable("media");
        // System.out.println("title"+media.getTitle ());
        // System.out.println("url"+media.getUrl ());
        // Picasso.get ().load (media.getUrl ()).into (selectedImage);

        String birdVideoUrl = getArguments().getString("libraryVideo");
        /**
         * use this media id to delete this media from user/media collection.
         */
        mediaID = getArguments().getString("mediaID");


        selectedVideo.setVideoPath(birdVideoUrl);
        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(selectedVideo);
        selectedVideo.setMediaController(mediaController);
        selectedVideo.start();

        //Button clicks
        saveVideobtn.setOnClickListener(this);
        shareVideobtn.setOnClickListener(this);

        //progress Dialog
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setTitle("AsyncTask");
        mProgressDialog.setMessage("Please wait, we are downloading your image file...");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.savevideobtn:
                saveVideo();
                break;
            case R.id.shareVideobtn:
                // sharevideo ();
                break;
            default:
                break;
        }
    }

    private void saveVideo() {
        // Toast.makeText(getActivity(), "Save button clicked", Toast.LENGTH_LONG).show();

        ContextWrapper cw = new ContextWrapper ( getActivity () );
        File directory = cw.getDir ( "birds", getActivity ().MODE_PRIVATE );
        String fileName = String.format ( "%d", System.currentTimeMillis () );

        File mypath = new File ( directory, fileName + ".mp4" );

        try {
            FileOutputStream newFile = new FileOutputStream ( mypath );
            //path 0 = current path of the video

            Toast.makeText (getActivity (),"Video saved Successfully",Toast.LENGTH_LONG ).show ();

            newFile.flush ();
            newFile.close ();

            //Send Broadcast to show an video in the Gallery
            Intent intent= new Intent ( Intent.ACTION_MEDIA_SCANNER_SCAN_FILE );
            intent.setData ( Uri.fromFile ( mypath ) );
            getActivity ().sendBroadcast(intent);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }
    }