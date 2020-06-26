package com.example.birdsadventure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> birdpictures;

    LayoutInflater inflter;

    public ImageAdapter(Context applicationContext, ArrayList<String> birdpictures) {
        this.context = applicationContext;
        this.birdpictures = birdpictures;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return birdpictures.size();
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
        view = inflter.inflate(R.layout.row_items, null); // inflate the layout
        ImageView icon = (ImageView) view.findViewById(R.id.imageLibrary); // get the reference of ImageView
        // icon.setImageResource( Integer.parseInt ( String.valueOf ( birdpictures[i] ) ) ); // set logo images
        Picasso.get().load(birdpictures.get(i)).into(icon);

        //TextView imagename=(TextView)view.findViewById (R.id.imageLibraryName );
        //imagename.setText ( birdpicturesnames[i] );
        return view;
    }
}