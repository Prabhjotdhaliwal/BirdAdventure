package com.example.birdsadventure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter <ImageAdapter.ImageViewHolder>{
private Context mContext;
private ArrayList< String > mUploads;

    public ImageAdapter(Context mContext, ArrayList< String > mUploads) {
        this.mContext = mContext;
        this.mUploads = mUploads;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View v=   LayoutInflater.from (parent.getContext ()).inflate (R.layout.birds_recycler_item, parent, false);
    return  new ImageViewHolder (v);

    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
//UserCollectionitem currentUserCollectionitem=mUploads.get (position);
    holder.textViewName.setText (mUploads.get (position));
    //Glide.with(mContext).load(mUploads.get (position)).into(holder.imageView);
        Picasso.get().load (mUploads.get (position)).fit ().into (holder.imageView);

        //Picasso.get().load (currentUserCollectionitem.getItemImage ()).fit ().into (holder.imageView);
       // Glide.with(mContext).load(currentUserCollectionitem.getImageURL()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return mUploads.size ();
    }

    public  class ImageViewHolder extends RecyclerView.ViewHolder{
public TextView textViewName;
public ImageView imageView;
        public ImageViewHolder(@NonNull View itemView) {
            super (itemView);
            textViewName=itemView.findViewById (R.id.card_title);
            imageView=itemView.findViewById (R.id.card_image);

        }
    }
}
