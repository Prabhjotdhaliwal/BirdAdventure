package com.example.birdsadventure;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
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
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoPlayerFragment extends Fragment implements View.OnClickListener {
    VideoView selectedVideo;
    Button saveVideobtn, shareVideobtn;
    ProgressDialog mProgressDialog;
    URL url;
    String mediaID;
String title="Video";

    //

    public VideoPlayerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate ( R.layout.fragment_video_player, container, false );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated ( view, savedInstanceState );

        selectedVideo = view.findViewById ( R.id.videoViewGallery ); // init a ImageView
        saveVideobtn = view.findViewById ( R.id.savevideobtn );
        shareVideobtn = view.findViewById ( R.id.shareVideobtn );


        //to get data from the parecelable such as img title & Url

        // Media media = getArguments().getParcelable("media");
        // System.out.println("title"+media.getTitle ());
        // System.out.println("url"+media.getUrl ());
        // Picasso.get ().load (media.getUrl ()).into (selectedImage);

        String birdVideoUrl = getArguments ().getString ( "libraryVideo" );
        /**
         * use this media id to delete this media from user/media collection.
         */
        mediaID = getArguments ().getString ( "mediaID" );


        selectedVideo.setVideoPath ( birdVideoUrl );
        MediaController mediaController = new MediaController ( getContext () );
        mediaController.setAnchorView ( selectedVideo );
        selectedVideo.setMediaController ( mediaController );
        selectedVideo.start ();

        //Button clicks
        saveVideobtn.setOnClickListener ( this );
        shareVideobtn.setOnClickListener ( this );

        //progress Dialog
        mProgressDialog = new ProgressDialog ( getActivity () );
        mProgressDialog.setIndeterminate ( true );
        mProgressDialog.setProgressStyle ( ProgressDialog.STYLE_SPINNER );
        mProgressDialog.setTitle ( "AsyncTask" );
        mProgressDialog.setMessage ( "Please wait, we are downloading your image file..." );

    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()) {
            case R.id.savevideobtn:
                saveVideo ();
                break;
            case R.id.shareVideobtn:
             //   sharevideo ();
                break;
            default:
                break;
        }
    }

    private void sharevideo()
    {
        try {
            String birdVideoUrl = getArguments ().getString ( "libraryVideo" );

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
            String shareMessage= "\nLet me recommend you this application\n\n";
            shareMessage = shareMessage + birdVideoUrl ;
            shareIntent.putExtra(Intent.EXTRA_TEXT, birdVideoUrl);
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch(Exception e) {
            //e.toString();
        }
        /*String birdVideoUrl = getArguments ().getString ( "libraryVideo" );
        String shareMessage= "\nLet me recommend you this application\n\n";
        shareMessage = shareMessage + birdVideoUrl ;

        Uri uri = Uri.parse ( birdVideoUrl );

        System.out.println ( url );
        File file = new File ( (uri.getPath ()) );

        Intent share = new Intent ( Intent.ACTION_SEND );
        share.setType ( "video/*" );

        share.putExtra ( Intent.EXTRA_STREAM, shareMessage );
        startActivity ( Intent
                .createChooser ( share, "Share video File" ) );

        Toast.makeText ( getActivity (), "sharevideoSelected", Toast.LENGTH_LONG ).show ();*/
    }

    private void saveVideo()
    {
        // Toast.makeText(getActivity(), "Save button clicked", Toast.LENGTH_LONG).show();

        String birdVideoUrl = getArguments ().getString ( "libraryVideo" );
downloadManager ( birdVideoUrl );
    }

    private void downloadManager(String url) {

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setDescription("download");
        request.setTitle(""+title);
// in order for this if to run, you must use the android 3.2 to compile your app
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, ""+title+".mp4");

// get download service and enqueue file
        DownloadManager manager = (DownloadManager) getActivity ().getSystemService( Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
         Toast.makeText(getActivity(), "Video Saved", Toast.LENGTH_LONG).show();


    }
    }
