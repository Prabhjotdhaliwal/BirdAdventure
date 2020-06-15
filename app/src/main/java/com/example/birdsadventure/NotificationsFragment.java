package com.example.birdsadventure;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotificationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotificationsFragment extends Fragment {

    private RecyclerView recyclerViewnotification;
    List<Notifications> itemlist;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public NotificationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotificationsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotificationsFragment newInstance(String param1, String param2) {
        NotificationsFragment fragment = new NotificationsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        recyclerViewnotification = view.findViewById(R.id.recycler_view_notification_birds);
        recyclerViewnotification.setLayoutManager(new LinearLayoutManager(getContext()));

        getAllNotifications();
        recyclerViewnotification.setAdapter(new NotificationAdapter(getAllNotifications()));


        return view;


    }

    private List<Notifications> getAllNotifications() {
        itemlist = new ArrayList<>();
        itemlist.add(new Notifications(R.drawable.ic_person, "This is the first Notification regarding your birds"));
        itemlist.add(new Notifications(R.drawable.ic_person, "This is the Second Notification regarding your birds"));
        itemlist.add(new Notifications(R.drawable.ic_person, "This is the Third Notification regarding your birds"));
        itemlist.add(new Notifications(R.drawable.ic_person, "This is the Fourth Notification regarding your birds"));
        return itemlist;
    }


}