package com.example.birdsadventure;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCanceledListener;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
            //  btnLoginClick();
            LoginUser();
        }
    }

    private void btnLoginClick() {

    }


    //SignInUser with firebase
    public void LoginUser() {
        final String usernameStr, passwordStr;

        usernameStr = txtEmail.getText().toString();
        passwordStr = txtPassword.getText().toString();

        if (TextUtils.isEmpty(usernameStr)) {
            txtEmail.setError("Email is Required ");

        }
        if (TextUtils.isEmpty(passwordStr)) {
            txtPassword.setError("Password is Required ");

        }
        if (passwordStr.length() < 8) {
            txtPassword.setError("Password must be >= 6 Characters");
        } else {
            //Authenticate the user
            firebaseAuth.signInWithEmailAndPassword(usernameStr, passwordStr)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Toast.makeText(LoginActivity.this, "hello", Toast.LENGTH_SHORT).show();
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "User has successfully logged in", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                                i.putExtra("currentuserk", usernameStr);
                                startActivity(i);


                            } else {
                                Toast.makeText(getApplicationContext(), "Authentication failed check your Email & Password", Toast.LENGTH_SHORT).show();

                            }
                        }

                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(LoginActivity.this, "hello i am an exception", Toast.LENGTH_SHORT).show();
                    Toast.makeText(LoginActivity.this, "prabhjot is stupid, why? ANs -> " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            })
            .addOnCanceledListener(new OnCanceledListener() {
                @Override
                public void onCanceled() {
                    Toast.makeText(LoginActivity.this, "hello cancel", Toast.LENGTH_SHORT).show();
                }
            });
            ;

        }
    }
}

