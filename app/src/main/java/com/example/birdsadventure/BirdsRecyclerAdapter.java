package com.example.birdsadventure;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BirdsRecyclerAdapter extends RecyclerView.Adapter<BirdsRecyclerAdapter.RecyclerViewHolder> {

    private ArrayList< Bird > birdsList;

    private boolean isVerticalList;
    private OnItemClickListener listenerAdapter;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        listenerAdapter = listener;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView txtTitle, txtBody;

        public RecyclerViewHolder(@NonNull View itemView, final OnItemClickListener listenerView) {
            super (itemView);
            image = itemView.findViewById (R.id.card_image);
            txtTitle = itemView.findViewById (R.id.card_title);

            itemView.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    if (listenerView != null) {
                        int position = getAdapterPosition ();
                        if (position != RecyclerView.NO_POSITION) {
                            listenerView.onItemClick (position);
                        }
                    }
                }
            });
        }
    }

    public BirdsRecyclerAdapter(ArrayList< Bird > birdsList, boolean isVerticalList) {
        this.birdsList = birdsList;
        this.isVerticalList = isVerticalList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (this.isVerticalList) {
            view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.birds_recycler_list_item, parent, false);
        } else {
            view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.birds_recycler_item, parent, false);
        }
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder (view, listenerAdapter);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        Bird currentBird = birdsList.get (position);

        holder.txtTitle.setText (currentBird.getName ());
        Picasso.get ().load (currentBird.getImageURL ()).into (holder.image);

    }

    @Override
    public int getItemCount() {
        return birdsList.size ();
    }
}