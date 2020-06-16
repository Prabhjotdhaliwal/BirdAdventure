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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private EditText txtName, txtAddress, txtPhone;
    User userDetails;

    FirebaseUser user;
    String userID;
    FirebaseFirestore db;

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

        db = FirebaseFirestore.getInstance();

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        txtName = getActivity().findViewById(R.id.txtNameProfile);
        txtAddress = getActivity().findViewById(R.id.txtAddressProfile);
        txtPhone = getActivity().findViewById(R.id.txtPhoneProfile);
        Button btnSaveProfile = getActivity().findViewById(R.id.btnSaveProfile);
        Button btnResetProfile = getActivity().findViewById(R.id.btnResetProfile);
        TextView changePassword = getActivity().findViewById(R.id.changePassword);

        btnSaveProfile.setOnClickListener(this);
        btnResetProfile.setOnClickListener(this);
        changePassword.setOnClickListener(this);
//        userID = HomeActivity.userID;
        getUserDetails();
    }

    private void getUserDetails() {
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            String email = user.getEmail();

            db.collection("Users").whereEqualTo("email", email)
                    .whereEqualTo("status", true).get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                QuerySnapshot documents = task.getResult();
                                if (documents.getDocuments().size() > 0) {
                                    userID = documents.getDocuments().get(0).getId();
                                    String name = documents.getDocuments().get(0).getString("name");
                                    String phone = documents.getDocuments().get(0).getString("phone");
                                    String address = documents.getDocuments().get(0).getString("address");

                                    userDetails = new User(name, "", phone, address);

                                    setUserDetails();
                                }
                            }
                        }
                    });
        }
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
            navController.navigate(R.id.changePasswordFragment);
        }
    }

    private void btnSaveProfileClick(View v) {

        final String name = txtName.getText().toString();
        final String phone = txtPhone.getText().toString();
        final String address = txtAddress.getText().toString();

        User userDetail = new User();
        userDetail.setName(name);
        userDetail.setPhone(phone);
        userDetail.setAddress(address);

        if (userID != null) {

            db.collection("Users").document(userID).update(
                    "name", name, "phone", phone, "address", address
            ).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getContext().getApplicationContext(), "Profile Updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext().getApplicationContext(), "Profile Update Failed!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}