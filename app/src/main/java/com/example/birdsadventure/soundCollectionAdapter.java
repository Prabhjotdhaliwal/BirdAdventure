package com.example.birdsadventure;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class soundCollectionAdapter extends RecyclerView.Adapter<soundCollectionAdapter.ViewHolder> {
    List<soundCollections> itemList1;

    public soundCollectionAdapter(List<soundCollections>itemList) {

    this.itemList1=itemList;


    }

    @NonNull
    @Override
    public soundCollectionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_collection_rowitem,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull soundCollectionAdapter.ViewHolder holder, int position) {
    holder.itemtxt.setText(itemList1.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return itemList1.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemtxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemtxt=itemView.findViewById(R.id.textsoundcollection);
        }
    }
}
