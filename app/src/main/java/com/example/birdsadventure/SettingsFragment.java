package com.example.birdsadventure;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class SettingsFragment extends Fragment implements View.OnClickListener {

    //    TextView txt_proximity_radius;
    AppCompatToggleButton favorites_notification_toggle;
    AppCompatToggleButton featured_notification_toggle;

    ArrayList<NotificationLocations> notificationLocationsList;
    ArrayList<String> birds;
    LocationManager mLocationManager;

    FirebaseUser user;
    FirebaseFirestore db;
    boolean isNotificationsAlert, isDefaultNotifications;
    boolean isFavoriteNotify, isFeaturedNotify;
    boolean isFavoriteNotifyInitial, isFeaturedNotifyInitial;
    String userID;
    String settingsID;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    public SettingsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = FirebaseFirestore.getInstance();

        sp = getActivity().getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);
        String notificationsAlert = sp.getString(MyVariables.keyNotificationsAlert, MyVariables.defaultNotificationsAlert);
        isNotificationsAlert = false;
        if (notificationsAlert.equals("")) {
            isDefaultNotifications = true;
        } else {
            isDefaultNotifications = false;
            if (notificationsAlert.equals("YES")) {
                isNotificationsAlert = true;
            }
        }
        isFavoriteNotify = false;
        isFeaturedNotify = false;
        isFavoriteNotifyInitial = false;
        isFeaturedNotifyInitial = false;

        favorites_notification_toggle = (AppCompatToggleButton) getActivity().findViewById(R.id.favorites_notification_toggle);
        featured_notification_toggle = (AppCompatToggleButton) getActivity().findViewById(R.id.featured_notification_toggle);

//        txt_proximity_radius = getActivity().findViewById(R.id.txt_proximity_radius);
        Button btnResetPassword = getActivity().findViewById(R.id.btnResetSettings);
        Button btnSavePassword = getActivity().findViewById(R.id.btnSaveSettings);

        btnSavePassword.setOnClickListener(this);
        btnResetPassword.setOnClickListener(this);

        getUserSettings();

        getListFromCache();
    }

    @Override
    public void onPause() {
        super.onPause();

        saveListInCache(false);
    }

    private void getUserSettings() {
        user = FirebaseAuth.getInstance().getCurrentUser();
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

                                    if (!isDefaultNotifications) {

                                        db.collection("Users").document(userID)
                                                .collection("Preferences").get()
                                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                        if (task.isSuccessful()) {
                                                            final QuerySnapshot documents = task.getResult();
                                                            if (documents.getDocuments().size() > 0) {
                                                                settingsID = documents.getDocuments().get(0).getId();
                                                                isFavoriteNotify = documents.getDocuments().get(0).getBoolean("get_favorites_notifications");
                                                                isFeaturedNotify = documents.getDocuments().get(0).getBoolean("get_featured_notifications");
                                                                isFavoriteNotifyInitial = isFavoriteNotify;
                                                                isFeaturedNotifyInitial = isFeaturedNotify;
                                                                resetFields();
                                                            }
                                                        }
                                                    }
                                                });
                                    }
                                }
                            }
                        }
                    });
        }

    }

    private void resetFields() {
        featured_notification_toggle.setChecked(isFeaturedNotify);
        favorites_notification_toggle.setChecked(isFavoriteNotify);
//        txt_proximity_radius.setText("1");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnResetSettings) {
            resetFields();
        } else if (v.getId() == R.id.btnSaveSettings) {
            btnSaveClick(v);
        }
    }

    private void btnSaveClick(View v) {

        final boolean isFeatured = featured_notification_toggle.isChecked();
        final boolean isFavorite = favorites_notification_toggle.isChecked();

        if (isDefaultNotifications || settingsID == null) {

            Settings settings = new Settings(isFavorite, isFeatured);
            db.collection("Users").document(userID).collection("Preferences").add(settings)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {

                            settingsID = documentReference.getId();
                            Toast.makeText(getActivity().getApplicationContext(), "Settings saved", Toast.LENGTH_LONG).show();
                            isFavoriteNotify = isFavorite;
                            isFeaturedNotify = isFeatured;
                            saveSettings();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity().getApplicationContext(), "Settings could not be saved", Toast.LENGTH_LONG).show();
                        }
                    });
        } else {
            db.collection("Users").document(userID).collection("Preferences").document(settingsID)
                    .update("get_favorites_notifications", isFavorite, "get_featured_notifications", isFeatured)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(getContext().getApplicationContext(), "Settings saved", Toast.LENGTH_SHORT).show();
                                isFavoriteNotify = isFavorite;
                                isFeaturedNotify = isFeatured;
                                saveSettings();
                            } else {
                                Toast.makeText(getContext().getApplicationContext(), "Settings could not be saved", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

    }

    private void saveSettings() {

        isDefaultNotifications = false;
        editor = sp.edit();

        if (!isFavoriteNotify && !isFeaturedNotify) {
            editor.putString(MyVariables.keyNotificationsAlert, "NO");
            editor.apply();

            UpdateNotificationLocationsList(false, false, false);

        } else {
            editor.putString(MyVariables.keyNotificationsAlert, "YES");
            editor.apply();

            if ((isFavoriteNotifyInitial == isFavoriteNotify) && (isFeaturedNotifyInitial == isFeaturedNotify)) {
                return;
            } else {
                UpdateNotificationLocationsList(true, isFavoriteNotify, isFeaturedNotify);
            }
        }

        isFavoriteNotifyInitial = isFavoriteNotify;
        isFeaturedNotifyInitial = isFeaturedNotify;
    }

    public void UpdateNotificationLocationsList(boolean isNotify, final boolean isFavorite, boolean isFeatured) {

//        Globals g = (Globals) getActivity().getApplication();

        notificationLocationsList = new ArrayList<NotificationLocations>();
        birds = new ArrayList<String>();

        final FirebaseFirestore db = FirebaseFirestore.getInstance();

        if (isNotify) {
            startBackgroundLocation();
            if (isFeatured) {

                db.collection("Birds").whereEqualTo("is_Featured", true).get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (DocumentSnapshot document : task.getResult()) {

                                        birds.add(document.getId());
                                    }
                                }
                                if (isFavorite) {
                                    addFavoriteBirds(true);
                                } else {
                                    addLocationFromBirdIds();
                                }
                            }
                        });
            } else {
                if (isFavorite) {
                    addFavoriteBirds(false);
                }
            }
        } else {
            saveListInCache(true);
        }
        isFavoriteNotify = isFavorite;
        isFeaturedNotify = isFeatured;
    }

    private void addFavoriteBirds(final boolean isFeaturedNotify) {

        db.collection("favorite_birds").whereEqualTo("user_id", userID)
                .whereEqualTo("is_favorite", true).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {

                                boolean isFeatured = document.getBoolean("is_Featured");

                                if (isFeaturedNotify && isFeatured) {
                                    continue;
                                }
                                birds.add(document.getId());
                            }
                        }
                        addLocationFromBirdIds();
                    }
                });
    }

    private void addLocationFromBirdIds() {

        notificationLocationsList = new ArrayList<NotificationLocations>();

        for (String birdId : birds) {
            db.collection("Bird_Location").whereEqualTo("bird_id", birdId).get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                final QuerySnapshot documents = task.getResult();
                                if (documents.getDocuments().size() > 0) {
                                    final String locationID = documents.getDocuments().get(0).getId();

                                    db.collection("Location").document(locationID).get()
                                            .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                @Override
                                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                    if (task.isSuccessful()) {
                                                        DocumentSnapshot documentSnapshot = task.getResult();

                                                        NotificationLocations notificationLocations = new NotificationLocations();

                                                        String latitude = documentSnapshot.getString("latitude");
                                                        String longitude = documentSnapshot.getString("longitude");
                                                        String proximity = documentSnapshot.getString("proximity");
                                                        String region = documentSnapshot.getString("Location_name");

                                                        notificationLocations.setLocationID(locationID);
                                                        notificationLocations.setLatitude(latitude);
                                                        notificationLocations.setLongitude(longitude);
                                                        notificationLocations.setProximityRadius(proximity);
                                                        notificationLocations.setRegion(region);

                                                        notificationLocationsList.add(notificationLocations);
                                                    }

                                                }
                                            });
                                }
                            }
                        }
                    });
        }
    }

    private void saveListInCache(boolean isEmpty) {

        Gson gson = new Gson();
        String json = gson.toJson(notificationLocationsList);
        String json2 = gson.toJson(birds);

        if (isEmpty) {
            json = "";
            json2 = "";
        }

        editor = sp.edit();
        editor.putString(MyVariables.keyNotificationLocationsList, json);
        editor.putString(MyVariables.keyNotificationBirdsList, json2);
        editor.apply();
    }

    private void getListFromCache() {

        Gson gson = new Gson();
        String json = sp.getString(MyVariables.keyNotificationLocationsList, "");
        if (json.isEmpty()) {
            notificationLocationsList = new ArrayList<NotificationLocations>();
        } else {
            Type type = new TypeToken<ArrayList<NotificationLocations>>() {
            }.getType();
            notificationLocationsList = gson.fromJson(json, type);
        }

        json = sp.getString(MyVariables.keyNotificationBirdsList, "");
        if (json.isEmpty()) {
            birds = new ArrayList<String>();
        } else {
            Type type = new TypeToken<ArrayList<String>>() {
            }.getType();
            birds = gson.fromJson(json, type);
        }

    }

    /**
     * notifications code below
     */

    public void startBackgroundLocation() {

        mLocationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 20000, 100, mLocationListener);

    }

    public void stopBackgroundLocation() {
//        isStopBackgroundThread = true;
        mLocationManager = null;
    }

    private void sendNotification(String title, String content) {

        String NOTIFICATION_CHANNEL_ID = "edmt_multiple_location";

        NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notification"
                    , NotificationManager.IMPORTANCE_DEFAULT);
            // cofig
            notificationChannel.setDescription("Channel Description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);

        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity().getApplicationContext(), NOTIFICATION_CHANNEL_ID);
        builder.setContentTitle(title)
                .setContentText(content)
                .setAutoCancel(false)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        Notification notification = builder.build();
        notificationManager.notify(new Random().nextInt(), notification);

    }

    private final android.location.LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(android.location.Location location) {

            double myLatitude = location.getLatitude();
            double myLongitude = location.getLongitude();

            getListFromCache();

            for (NotificationLocations locations : notificationLocationsList) {

                double currentLatitude = Double.parseDouble(locations.getLatitude());
                double currentLongitude = Double.parseDouble(locations.getLongitude());
                long proximity = Long.parseLong(locations.getProximityRadius());
                String region = locations.getRegion();

                float[] results = new float[1];
                Location.distanceBetween(currentLatitude, currentLongitude, myLatitude, myLongitude, results);
                float distanceInMeters = results[0];

                if (distanceInMeters <= proximity) {
                    String content = "Click here to view Birds found at " + region;
                    saveNotificationInFirebase(region, locations.getLocationID());
                    sendNotification(region, content);
                    break;
                }
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    private void saveNotificationInFirebase(String region, String locationID) {

        Notifications notifications = new Notifications();

        notifications.setDeleted(false);
        notifications.setLocationID(locationID);
        notifications.setRegion(region);
        notifications.setDateReceived(new Date());

        db.collection("Users").document(userID).collection("Notifications").add(notifications)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getActivity().getApplicationContext(), "Notification Saved", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}