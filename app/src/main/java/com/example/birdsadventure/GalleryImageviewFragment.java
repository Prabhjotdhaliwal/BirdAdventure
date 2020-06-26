package com.example.birdsadventure;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;


public class GalleryImageviewFragment extends Fragment implements View.OnClickListener {
    ImageView selectedImage;
    Button saveImagebtn, shareimagebtn;
    ProgressDialog mProgressDialog;
    URL url;
    Bitmap bitmap;
    String mediaID;
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

        selectedImage = view.findViewById(R.id.selectedImage); // init a ImageView
        saveImagebtn = view.findViewById(R.id.saveimgbtn);
        shareimagebtn = view.findViewById(R.id.shareimgbtn);


        //to get data from the parecelable such as img title & Url

        String birdImgUrl = getArguments().getString("libraryImage");
        /**
         * use this media id to delete this media from user/media collection.
         */
        mediaID = getArguments().getString("mediaID");

        // Media media = getArguments().getParcelable("media");
        // System.out.println("title"+media.getTitle ());
        // System.out.println("url"+media.getUrl ());
        Picasso.get().load(birdImgUrl).into(selectedImage);

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
                //  saveimagetogallery ();
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    }

    private void saveimagetogallery() {
        Toast.makeText(getActivity(), "Save button clicked", Toast.LENGTH_LONG).show();
        //  DownloadTask    mMyTask = (DownloadTask) new DownloadTask().execute(stringToURL());
        mProgressDialog.show();
        BitmapDrawable drawable = (BitmapDrawable) selectedImage.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        try {
            String root = Environment.getExternalStorageDirectory().toString();
            File file = new File(root + "/Pictures/myImagesDGS.jpg");
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private void shareimage() {
        Toast.makeText(getActivity(), "Share button clicked", Toast.LENGTH_LONG).show();
    }


    //code commented to download an image from url
 /*   private class DownloadTask extends AsyncTask<URL,Void,Bitmap> {

        protected void onPreExecute(){
            mProgressDialog.show();
        }
        protected Bitmap doInBackground(URL...urls){
            URL url = urls[0];
            HttpURLConnection connection = null;
            try{
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                return BitmapFactory.decodeStream(bufferedInputStream);
            }catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }
        // When all async task done
        protected void onPostExecute(Bitmap result){
            // Hide the progress dialog
            mProgressDialog.dismiss();
            if(result!=null){
                selectedImage.setImageBitmap(result);
            } else {
                // Notify user that an error occurred while downloading image
                Toast.makeText(getActivity (), "Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
    protected URL stringToURL() {
        try {
             url = new URL ( "https://wallpapersite.com/images/pages/pic_w/6408.jpg" );
            return url;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}

