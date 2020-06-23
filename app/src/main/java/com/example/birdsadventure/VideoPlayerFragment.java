package com.example.birdsadventure;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URL;

public class VideoPlayerFragment extends Fragment implements View.OnClickListener {
    VideoView selectedVideo;
    Button saveVideobtn,shareVideobtn;
    ProgressDialog mProgressDialog;
    URL url;

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

        selectedVideo = view.findViewById (R.id.videoViewGallery); // init a ImageView
        saveVideobtn = view.findViewById (R.id.savevideobtn);
        shareVideobtn = view.findViewById (R.id.shareVideobtn);


        //to get data from the parecelable such as img title & Url

        // Media media = getArguments().getParcelable("media");
        // System.out.println("title"+media.getTitle ());
        // System.out.println("url"+media.getUrl ());
        // Picasso.get ().load (media.getUrl ()).into (selectedImage);


        selectedVideo.setVideoPath("http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4");
        MediaController mediaController=new MediaController (getContext ());
        mediaController.setAnchorView (selectedVideo);
        selectedVideo.setMediaController (mediaController);
        selectedVideo.start();

        //Button clicks
        saveVideobtn.setOnClickListener (this);
        shareVideobtn.setOnClickListener (this);

        //progress Dialog
        mProgressDialog = new ProgressDialog (getActivity ());
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setTitle("AsyncTask");
        mProgressDialog.setMessage("Please wait, we are downloading your image file...");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId ())
        {
            case R.id.savevideobtn:
                //save video();
                break;
            case R.id.shareVideobtn:
               // sharevideo ();
                break;
            default:
                break;
    }
}
}