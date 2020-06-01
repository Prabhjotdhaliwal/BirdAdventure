package com.example.birdsadventure;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment implements View.OnClickListener {

    TextView txt_proximity_radius;
    AppCompatToggleButton favorites_notification_toggle;
    AppCompatToggleButton featured_notification_toggle;

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

        favorites_notification_toggle = (AppCompatToggleButton) getActivity().findViewById(R.id.favorites_notification_toggle);
        featured_notification_toggle = (AppCompatToggleButton) getActivity().findViewById(R.id.featured_notification_toggle);

        txt_proximity_radius = getActivity().findViewById(R.id.txt_proximity_radius);
        Button btnResetPassword = getActivity().findViewById(R.id.btnResetSettings);
        Button btnSavePassword = getActivity().findViewById(R.id.btnSaveSettings);

        btnSavePassword.setOnClickListener(this);
        btnResetPassword.setOnClickListener(this);

        getUserSettings();

        //Toggle button state change listeners

        favorites_notification_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getActivity().getApplicationContext(), "Favorites notifications - ON", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Favorites notifications - OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

        featured_notification_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getActivity().getApplicationContext(), "Featured notifications - ON", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Featured notifications - OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void getUserSettings() {

        /**
         * Get user settings from FireStore
         */

        txt_proximity_radius.setText("1");
    }

    private void resetFields() {
        featured_notification_toggle.setChecked(false);
        favorites_notification_toggle.setChecked(false);
        txt_proximity_radius.setText("1");
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

        /**
         * Save settings in FireStore
         */

        Toast.makeText(getActivity().getApplicationContext(), "Settings saved", Toast.LENGTH_SHORT).show();

    }
}