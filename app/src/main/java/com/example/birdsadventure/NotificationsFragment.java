package com.example.birdsadventure;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private RecyclerView recyclerViewNotifications;
    TextView txt_no_notifications;
    List<Notifications> notificationsList;
    String userID;

    FirebaseFirestore db;

    private NavController navController;

    public NotificationsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = FirebaseFirestore.getInstance();

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        txt_no_notifications = view.findViewById(R.id.txt_no_notifications);
        txt_no_notifications.setText("");
        recyclerViewNotifications = view.findViewById(R.id.recycler_view_notification_birds);
        recyclerViewNotifications.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));


        getAllNotifications();

    }

    private void getAllNotifications() {
        notificationsList = new ArrayList<>();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            String email = user.getEmail();

            db.collection("Users").whereEqualTo("email", email)
                    .whereEqualTo("status", true).get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                final QuerySnapshot documents = task.getResult();
                                if (documents.getDocuments().size() > 0) {
                                    userID = documents.getDocuments().get(0).getId();

                                    db.collection("Users").document(userID).collection("Notifications")
                                            .whereEqualTo("isDeleted", false).get()
                                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                                @Override
                                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                    if (task.isSuccessful()) {
                                                        QuerySnapshot documents = task.getResult();
                                                        if (documents.getDocuments().size() > 0) {

                                                            txt_no_notifications.setText("");

                                                            for (QueryDocumentSnapshot document : documents) {
                                                                Date date = document.getDate("dateReceived");
                                                                String region = document.getString("region");
                                                                String locationID = document.getString("locationID");

                                                                Notifications notifications = new Notifications();
                                                                notifications.setDateReceived(date);
                                                                notifications.setRegion(region);
                                                                notifications.setDeleted(false);
                                                                notifications.setLocationID(locationID);

                                                                notificationsList.add(notifications);
                                                            }
                                                        } else {

                                                            txt_no_notifications.setText("No Notifications found.");
                                                        }
                                                    }

                                                    NotificationAdapter notificationAdapter = new NotificationAdapter(notificationsList);
                                                    recyclerViewNotifications.setAdapter(notificationAdapter);

                                                    notificationAdapter.setOnItemClickListener(new NotificationAdapter.OnItemClickListener() {
                                                        @Override
                                                        public void onItemClick(int position) {

                                                            Bundle bundle = new Bundle();
                                                            bundle.putString("locationID", notificationsList.get(position).getLocationID());
                                                            bundle.putString("region", notificationsList.get(position).getRegion());
                                                            navController.navigate(R.id.notificationBirdsFragment, bundle);

                                                        }
                                                    });
                                                }
                                            });
                                }
                            }
                        }
                    });
        }

    }

}