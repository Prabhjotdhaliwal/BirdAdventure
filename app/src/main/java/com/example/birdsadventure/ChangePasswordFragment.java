package com.example.birdsadventure;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class ChangePasswordFragment extends Fragment implements View.OnClickListener {

    private NavController navController;

    private EditText txtCurrentPassword, txtNewPassword, txtNewConfirmPassword;

    public ChangePasswordFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_change_password, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        txtCurrentPassword = getActivity().findViewById(R.id.txtCurrentPassword);
        txtNewPassword = getActivity().findViewById(R.id.txtNewPassword);
        txtNewConfirmPassword = getActivity().findViewById(R.id.txtNewConfirmPassword);
        Button btnResetPassword = getActivity().findViewById(R.id.btnResetPassword);
        Button btnSavePassword = getActivity().findViewById(R.id.btnSavePassword);

        btnSavePassword.setOnClickListener(this);
        btnResetPassword.setOnClickListener(this);
    }

    private void resetFields() {
        txtCurrentPassword.setText("");
        txtNewPassword.setText("");
        txtNewConfirmPassword.setText("");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnResetPassword) {
            resetFields();
        } else if (v.getId() == R.id.btnSavePassword) {
            btnSavePasswordClick(v);
        }
    }

    private void btnSavePasswordClick(View v) {

        final String passwordRequired = "New Password is Required";
        final String passwordShort = "New Password Must be >= 6 Characters";
        final String passwordMatch = "Passwords do not match";

        String currentPassword = txtCurrentPassword.getText().toString().trim();
        String newPassword = txtNewPassword.getText().toString().trim();
        String newConfirmPassword = txtNewConfirmPassword.getText().toString().trim();

        if (TextUtils.isEmpty(newPassword)) {
            txtNewPassword.requestFocus();
            txtNewPassword.setError(passwordRequired);
            return;
        }

        if (newPassword.length() < 6) {
            txtNewPassword.requestFocus();
            txtNewPassword.setError(passwordShort);
            return;
        }

        if (!newConfirmPassword.equals(newPassword)) {
            txtNewConfirmPassword.requestFocus();
            txtNewConfirmPassword.setError(passwordMatch);
            return;
        }

        /**
         * Save new password in FireStore
         */

        Toast.makeText(getActivity().getApplicationContext(), "password changed", Toast.LENGTH_SHORT).show();

        resetFields();
    }
}