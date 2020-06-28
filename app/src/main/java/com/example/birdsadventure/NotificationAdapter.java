package com.example.birdsadventure;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    List<Notifications> notificationsList;
    private NotificationAdapter.OnItemClickListener listenerAdapter;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(NotificationAdapter.OnItemClickListener listener) {
        listenerAdapter = listener;
    }

    public NotificationAdapter(List<Notifications> notificationsList) {
        this.notificationsList = notificationsList;
    }

    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notificationrows, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, listenerAdapter);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Date date = notificationsList.get(position).getDateReceived();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String strDate = formatter.format(date);
        String region = notificationsList.get(position).getRegion();
        String title = region + " - ";
        String description = "Click here to view Birds found at " + region;

        holder.notificationDate.setText(strDate);
        holder.notificationTitle.setText(title);
        holder.notificationDescription.setText(description);
    }

    @Override
    public int getItemCount() {
        return notificationsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView notificationTitle, notificationDescription, notificationDate;

        public ViewHolder(@NonNull View itemView, final NotificationAdapter.OnItemClickListener listenerView) {
            super(itemView);

            notificationTitle = itemView.findViewById(R.id.notificationTitle);
            notificationDescription = itemView.findViewById(R.id.notificationDescription);
            notificationDate = itemView.findViewById(R.id.notificationDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listenerView != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listenerView.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
