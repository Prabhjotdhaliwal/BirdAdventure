package com.example.birdsadventure;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.birdsadventure.R;
import com.squareup.picasso.Picasso;

public class ImageAdapter extends BaseAdapter {
    Context context;
    int birdpictures[];
    String   birdpicturesnames[];

    LayoutInflater inflter;
    public ImageAdapter(Context applicationContext, int[] birdpictures,String []birdpicturesnames) {
        this.context = applicationContext;
        this.birdpictures = birdpictures;
        this.birdpicturesnames=birdpicturesnames;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return birdpictures.length;
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
        view = inflter.inflate( R.layout.row_items, null); // inflate the layout
        ImageView icon = (ImageView) view.findViewById(R.id.imageLibrary); // get the reference of ImageView
        icon.setImageResource(birdpictures[i]); // set logo images

        TextView imagename=(TextView)view.findViewById (R.id.imageLibraryName );
        imagename.setText ( birdpicturesnames[i] );
        return view;
    }
}