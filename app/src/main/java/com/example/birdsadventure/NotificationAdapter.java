package com.example.birdsadventure;

import android.app.Notification;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

List<Notifications> itemlist1;

    public NotificationAdapter(List<Notifications> itemlist) {
      this.itemlist1=itemlist;
    }

    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.notificationrows,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemimage.setImageResource(itemlist1.get(position).getImage());
        holder.itemDescription.setText(itemlist1.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return itemlist1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemimage;
        TextView itemDescription;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemimage= itemView.findViewById(R.id.imageviewnotification);
            itemDescription=itemView.findViewById(R.id.textviewnotification);



        }
    }
}
