package com.example.birdsadventure;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth fireBaseAuth;
    /* Declaration of edit text boxes */
    EditText txtName, txtEmail, txtPassword, txtPhone, txtAddress, txtConfirmPassword;

    Button btnSignUp;                         /* Declaration of sign up button */
    FirebaseAuth firebaseAuth;                /* Declaration of firebase authentication to get backend services */

    SharedPreferences sp;
    /**
     * Shared preferences declaration to save login information
     */
    SharedPreferences.Editor editor;          /* This Interface used for modifying values in a SharedPreferences object  */

    boolean isLogin;                          /* To check if user is already logged in or not */


    String currentUserID;                   /** Returns the ID of the current user if they are logged in */

    /**
     * To set the layout of the activity from which it is invoked
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        /** To check if user is already logged in if yes call navigateToHome() method */
        if (validateAutomaticLogin()) {
            navigateToHome();
        }
        /** finds the view from the layout resource */
        txtName = findViewById(R.id.txtNameSignUp);
        txtEmail = findViewById(R.id.txtEmailSignUp);
        txtPassword = findViewById(R.id.txtPasswordSignUp);
        txtPhone = findViewById(R.id.txtPhoneSignUp);
        txtAddress = findViewById(R.id.txtAddressSignUp);
        txtConfirmPassword = findViewById(R.id.txtConfirmPassword);

        /** For user authentication we have to take reference to the FirebaseAuth.
         * getInstance functionality used to take reference */
        fireBaseAuth = FirebaseAuth.getInstance();

        /** To connect SignUp Button with the current activity */
        btnSignUp = findViewById(R.id.btnSignUp);

        /** To implement clicking functionality on sign up button */
        btnSignUp.setOnClickListener(this);

    }

    /**
     * To call reigsterUser method after clicking on signup button
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSignUp) {
            registerUser();
        }
    }

    /**
     * To check user is already logged in by checking the key values in shared preferences
     * Return true if isLogin & currentUserID are equal
     */
    private boolean validateAutomaticLogin() {
        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);      /**Code to retrieve data */

        isLogin = sp.getBoolean(MyVariables.keyLoginAuth, MyVariables.defaultLoginAuth);
        currentUserID = sp.getString(MyVariables.keyUserID, MyVariables.defaultUserID);

        if (isLogin && !currentUserID.equals("")) {
            return true;
        }
        return false;
    }

    /**
     * To navigate user to the home screen that is MainActivity
     */
    private void navigateToHome() {
        finish();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }

    /**
     * get data from user( name, email, phone, address, password and confirm password) to sign up
     */
    private void registerUser() {

        /** To fetch text from edit text boxes */
        final String name = txtName.getText().toString().trim();
        final String email = txtEmail.getText().toString().trim();
        final String phone = txtPhone.getText().toString().trim();
        final String address = txtAddress.getText().toString();
        String password = txtPassword.getText().toString().trim();
        String confirmPassword = txtConfirmPassword.getText().toString();

        /**  Check if the (Name, email, password) is entered or not by the user */
        if (TextUtils.isEmpty(name)) {
            txtName.requestFocus();
            txtName.setError("Name is Required ");
            return;
        }
        if (TextUtils.isEmpty(email)) {
            txtEmail.requestFocus();
            txtEmail.setError("Email is Required ");
            return;
        }
        /** Check if the email pattern is correct or not */
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            txtEmail.requestFocus();
            txtEmail.setError("Invalid Email");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            txtPassword.requestFocus();
            txtPassword.setError("Password is Required ");
            return;
        }
        /** check if password length is less than 8 */
        if (password.length() < 8) {
            txtPassword.requestFocus();
            txtPassword.setError("Password must be >= 8 Characters");
            return;
        }
        /** check if confirm password or password equal or not */
        if (!confirmPassword.equals(password)) {
            txtConfirmPassword.requestFocus();
            txtConfirmPassword.setError("Passwords do not match");
            return;
        }
        /** To save user credentials (name, email, phone, address) only in the Users column */
        final User user = new User(name, email, phone, address, true);

        /** create the user with email and password
         *  and store user details in database under the User column
         *  then navigate user to the home page
         * @param email
         * @param password
         */
        fireBaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Log.d("TAG", "createUserWithEmail:success");

                            FirebaseFirestore db = FirebaseFirestore.getInstance();


                            db.collection("Users").add(user)
                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            Log.d("TAG", "AddUserToDB:success");
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    e.printStackTrace();
                                }
                            });

                            navigateToHome();
                        }
                    }
                });
    }

    /**
     * Save the data of the current logged in user in shared preferences
     * MyVariables used to save key values (keyLoginAuth,keyUserID)
     */
    private void saveUserDetails() {

        editor = sp.edit();

        /** firebaseUser an object containing the details about the user */
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            String userId = firebaseUser.getUid();
            String userEmail = firebaseUser.getEmail();

            editor.putBoolean(MyVariables.keyLoginAuth, true);
            editor.putString(MyVariables.keyUserID, userId);
        } else {
            editor.putBoolean(MyVariables.keyLoginAuth, false);
            editor.putString(MyVariables.keyUserID, "");
        }
        editor.apply();
    }
}