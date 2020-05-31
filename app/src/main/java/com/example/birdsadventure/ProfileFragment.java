package com.example.birdsadventure;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private EditText txtName, txtAddress, txtPhone;
    User userDetails;

    private NavController navController;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        txtName = getActivity().findViewById(R.id.txtNameProfile);
        txtAddress = getActivity().findViewById(R.id.txtAddressProfile);
        txtPhone = getActivity().findViewById(R.id.txtPhoneProfile);
        Button btnSaveProfile = getActivity().findViewById(R.id.btnSaveProfile);
        Button btnResetProfile = getActivity().findViewById(R.id.btnResetProfile);
        TextView changePassword=getActivity().findViewById(R.id.changePassword);

        btnSaveProfile.setOnClickListener(this);
        btnResetProfile.setOnClickListener(this);
        changePassword.setOnClickListener(this);
//        userID = HomeActivity.userID;
        getUserDetails();
    }

    private void getUserDetails() {

        /**
         * TODO: get user details from FireStore.
         */

        /**
         * Temporary assigning user details
         */
        userDetails = new User("sample", "", "11223344", "123 sample street");

        setUserDetails();
    }

    private void setUserDetails() {
        txtName.setText(userDetails.getName());
        txtAddress.setText(userDetails.getAddress());
        txtPhone.setText(userDetails.getPhone());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnResetProfile) {
            setUserDetails();
        } else if (v.getId() == R.id.btnSaveProfile) {
            btnSaveProfileClick(v);
        } else if (v.getId() == R.id.changePassword) {
            Toast.makeText(getActivity().getApplicationContext(), "change password page", Toast.LENGTH_SHORT).show();
        }
    }

    private void btnSaveProfileClick(View v) {

        /**
         * TODO: get user details from FireStore.
         */

        Toast.makeText(getActivity().getApplicationContext(), "Data saved", Toast.LENGTH_SHORT).show();
    }
}