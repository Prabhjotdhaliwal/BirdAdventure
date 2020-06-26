package com.example.birdsadventure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VideoAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> birdVideos;

    LayoutInflater inflater;

    public VideoAdapter(Context applicationContext, ArrayList<String> birdVideos) {
        this.context = applicationContext;
        this.birdVideos = birdVideos;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return birdVideos.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.video_row_items, null); // inflate the layout
        //ImageView icon = (ImageView) view.findViewById(R.id.videoLibrary); // get the reference of ImageView
        // icon.setImageResource( Integer.parseInt ( String.valueOf ( birdpictures[i] ) ) ); // set logo images
        //Picasso.get().load(birdVideos.get(i)).into(icon);

        //TextView imagename=(TextView)view.findViewById (R.id.imageLibraryName );
        //imagename.setText ( birdpicturesnames[i] );
        return view;
    }
}