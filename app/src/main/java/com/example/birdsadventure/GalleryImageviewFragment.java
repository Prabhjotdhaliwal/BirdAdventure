
package com.example.birdsadventure;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;


public class GalleryImageviewFragment extends Fragment implements View.OnClickListener {
    ImageView SelectedImage;
    Button saveImagebtn, shareimagebtn;
    ProgressDialog mProgressDialog;
    URL url;
    String mediaID;
    String birdImgUrl;
    BitmapDrawable drawable;
    Bitmap bitmap;


    OutputStream outputStream;
    private static int WRITE_EXTERNAL_STORAGE_CODE = 1;


    public GalleryImageviewFragment() {
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


        return inflater.inflate(R.layout.fragment_gallery_imageview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SelectedImage = view.findViewById(R.id.selectedImage); // init a ImageView
        saveImagebtn = view.findViewById(R.id.saveimgbtn);
        shareimagebtn = view.findViewById(R.id.shareimgbtn);


        //to get data from the parecelable such as img title & Url

         birdImgUrl = getArguments().getString("libraryImage");
        /**
         * use this media id to delete this media from user/media collection.
         */
        mediaID = getArguments().getString("mediaID");

        // Media media = getArguments().getParcelable("media");
        // System.out.println("title"+media.getTitle ());
        // System.out.println("url"+media.getUrl ());
        Picasso.get().load(birdImgUrl).into(SelectedImage);

        //Button clicks
        saveImagebtn.setOnClickListener(this);
        shareimagebtn.setOnClickListener(this);

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
            case R.id.saveimgbtn:
                saveimagetogallery ();
                break;
            case R.id.shareimgbtn:
                shareimage();
                break;
            default:
                break;
        }
    }

    private boolean checkSelfPermission(String writeExternalStorage) {
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
    }


    //to save a picture in deice storage
    private void saveimagetogallery()
    {
        // Toast.makeText(getActivity(), "Save button clicked", Toast.LENGTH_LONG).show();


        // to get an iimage from an imageview
        drawable = (BitmapDrawable)SelectedImage.getDrawable ();
        bitmap=drawable.getBitmap ();



        //Generate directory
        FileOutputStream outputStream=null;
        File sdCard= Environment.getExternalStorageDirectory ();
        File directory =new File(sdCard.getAbsoluteFile ()+"/birds");
        directory.mkdir ();
        String fileName = String.format ( "%d.jpg",System.currentTimeMillis () );
        File outFile=new File(directory,fileName);
        Toast.makeText (getActivity (),"image saved Successfully",Toast.LENGTH_LONG ).show ();

        try
        {
            outputStream=new FileOutputStream ( outFile );
            bitmap.compress ( Bitmap.CompressFormat.JPEG,100,outputStream );
            outputStream.flush ();
            outputStream.close ();


            //Send Broadcast to show an image in the Gallery
            Intent intent= new Intent ( Intent.ACTION_MEDIA_SCANNER_SCAN_FILE );
            intent.setData ( Uri.fromFile ( outFile ) );
            getActivity ().sendBroadcast(intent);

        } catch (FileNotFoundException e)
        {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }

//to share an image in other applications such as Facebook,instagram etc..
    private void shareimage()
    {
        drawable = (BitmapDrawable)SelectedImage.getDrawable ();
        bitmap=drawable.getBitmap ();

        FileOutputStream outputStream=null;
        File sdCard= Environment.getExternalStorageDirectory ();
        File directory =new File(sdCard.getAbsoluteFile ()+"/birds");
        directory.mkdir ();
        String fileName = String.format ( "%d.jpg",System.currentTimeMillis () );
        File outFile=new File(directory,fileName);

        try
        {
            outputStream=new FileOutputStream ( outFile );
            bitmap.compress ( Bitmap.CompressFormat.JPEG,100,outputStream );
            outputStream.flush ();
            outputStream.close ();

            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
            sharingIntent.setType("image/*");

            Uri uri = Uri.fromFile(outFile);
            System.out.println ( uri );
           sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);
           sharingIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
           sharingIntent.setType("image/jpg");


        startActivity(Intent.createChooser(sharingIntent, "Share via"));


    }
        catch (FileNotFoundException e)
        {
            e.printStackTrace ();
        } catch (IOException e)
        {
            e.printStackTrace ();
        }

    }}

