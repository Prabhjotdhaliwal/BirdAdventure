package com.example.birdsadventure;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FeatureBirdRecyclerView extends RecyclerView.Adapter<FeatureBirdRecyclerView.FeaturedBirdViewHolder> {

    private String[] items;

    public FeatureBirdRecyclerView(String[] items) {
        this.items = items;
    }

    @Override
    public FeaturedBirdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return  null;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedBirdViewHolder holder, int position)
    {
    }



    @Override
    public int getItemCount() {
        return items.length;
    }

    public class FeaturedBirdViewHolder extends RecyclerView.ViewHolder{
        TextView featuredbirdname;
        ImageView featuredbirdimage;

        public FeaturedBirdViewHolder(@NonNull View itemView) {
            super(itemView);
            featuredbirdname = (TextView) itemView.findViewById(R.id.featuredbirdname);
           featuredbirdimage = (ImageView) itemView.findViewById(R.id.featuredbirdimage);
        }
    }
}
