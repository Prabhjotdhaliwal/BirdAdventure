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

    EditText txtEmail, txtPassword;
    Button btnLogin;
    FirebaseAuth firebaseAuth;

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    boolean isLogin;
    String currentUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (validateAutomaticLogin()) {
            navigateToHome();
        }

        //Initialize the firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        txtEmail = findViewById(R.id.txtEmailLogin);
        txtPassword = findViewById(R.id.txtPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //  FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        //System.out.println (currentUser);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin) {
            btnLoginClick();
        }
    }

    private boolean validateAutomaticLogin() {
        sp = getSharedPreferences(MyVariables.cacheFile, Context.MODE_PRIVATE);

        isLogin = sp.getBoolean(MyVariables.keyLoginAuth, MyVariables.defaultLoginAuth);
        currentUserID = sp.getString(MyVariables.keyUserID, MyVariables.defaultUserID);

        if (isLogin && !currentUserID.equals("")) {
            return true;
        }
        return false;
    }

    private void navigateToHome() {
        finish();
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    //SignInUser with firebase
    private void btnLoginClick() {
        String username;
        String password;

        username = txtEmail.getText().toString();
        password = txtPassword.getText().toString();

        if (TextUtils.isEmpty(username)) {
            txtEmail.setError("Email is Required ");

        }
        if (TextUtils.isEmpty(password)) {
            txtPassword.setError("Password is Required ");

        }
        if (password.length() < 8) {
            txtPassword.setError("Password must be >= 6 Characters");
        } else {
            //Authenticate the user
            firebaseAuth.signInWithEmailAndPassword(username, password)
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

                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(LoginActivity.this, "Error -> " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        }
    }

    private void saveUserDetails() {

        editor = sp.edit();
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

