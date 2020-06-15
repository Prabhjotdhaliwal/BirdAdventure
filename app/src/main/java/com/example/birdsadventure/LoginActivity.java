package com.example.birdsadventure;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtEmail, txtPassword;           /** Declaration of edit text boxes */
    Button btnLogin;                          /** Declaration of login button */
    FirebaseAuth firebaseAuth;                /* Declaration of firebase authentication to get backend services */

    SharedPreferences sp;                     /** Shared preferences declaration to save login information  */
    SharedPreferences.Editor editor;          /** This Interface used for modifying values in a SharedPreferences object */
    boolean isLogin;                          /** To check if user is already logged in or not */
    String currentUserID;                     /** Returns the ID of the current user if they are logged in */

    /** To set the layout of the activity from which it is invoked. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /** To check if user is already logged in if yes call navigateToHome() method */
        if (validateAutomaticLogin()) {
            navigateToHome();
        }

        /*
         * For user authentication we have to take reference to the FirebaseAuth.
         * getInstance functionality used to take reference
         */
        firebaseAuth = FirebaseAuth.getInstance();

        /** To connect edit text boxes with the current activity */
        txtEmail = findViewById(R.id.txtEmailLogin);
        txtPassword = findViewById(R.id.txtPasswordLogin);

        /** To connect button with the current activity */
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //  FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        //System.out.println (currentUser);
    }

    /** To call btnLoginClick method when clicking on login button
     *@param v
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin) {
            btnLoginClick();
        }
    }

    /** To check user is already logged in by checking the key values in shared preferences
     *  Return true if isLogin & currentUserID are equal otherwise return false
     */
    private boolean validateAutomaticLogin() {
        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);       /**Code to retrieve data */

        isLogin = sp.getBoolean(MyVariables.keyLoginAuth, MyVariables.defaultLoginAuth);
        currentUserID = sp.getString(MyVariables.keyUserID, MyVariables.defaultUserID);

        if (isLogin && !currentUserID.equals("")) {
            return true;
        }
        return false;
    }
    /** Navigate user to the home page after login authentication*/
    private void navigateToHome() {
        finish();
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    /** The method btnLoginClick() is used for login button functionality*/
    private void btnLoginClick() {

        /** To get login information from the user  */
        final String userName = txtEmail.getText().toString().trim();
        final String password = txtPassword.getText().toString().trim();

        /** Check if the user name and password is entered or not by the user */
        if (TextUtils.isEmpty(userName)) {
            txtEmail.requestFocus();
            txtEmail.setError("Email is Required ");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            txtPassword.requestFocus();
            txtPassword.setError("Password is Required ");
            return;
        }
        /** Check the password conditions */
        if (password.length() < 8) {
            txtPassword.requestFocus();
            txtPassword.setError("Password must be >= 8 Characters");
            return;
        }

        /** verify login details with the database
         * If login credentials matches with the database then navigate user to the home page
         * @param userName,
         * @param password
         * */
        firebaseAuth.signInWithEmailAndPassword(userName, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(LoginActivity.this, "hello", Toast.LENGTH_SHORT).show();


                        if (task.isSuccessful()) {

                            saveUserDetails();

                            navigateToHome();
                        } else {
                            Toast.makeText(getApplicationContext(), "Authentication failed check your Email & Password", Toast.LENGTH_SHORT).show();

                        }
                    }
                    /** failure listener is called when the task unable to complete due to problem or error */
                }).addOnFailureListener(new OnFailureListener() {
            @Override

            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "Error -> " + e.getMessage(), Toast.LENGTH_LONG).show();
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

