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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class ChangePasswordFragment extends Fragment implements View.OnClickListener {

    private NavController navController;

    FirebaseUser user;
    FirebaseFirestore db;

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

        db = FirebaseFirestore.getInstance();

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
        final String newPassword = txtNewPassword.getText().toString().trim();
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

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            String email = user.getEmail();
            AuthCredential credential = EmailAuthProvider
                    .getCredential(email, currentPassword);

            user.reauthenticate(credential)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                user.updatePassword(newPassword).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getActivity().getApplicationContext(), "Password Updated", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(getActivity().getApplicationContext(), "Password Update Failed", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(getActivity().getApplicationContext(), "Current Password Incorrect", Toast.LENGTH_SHORT).show();
                            }

                            resetFields();
                        }
                    });
        }
    }
}