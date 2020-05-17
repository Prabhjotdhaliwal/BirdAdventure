package com.example.birdsadventure;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtEmail, txtPassword, txtPhone, txtAddress, txtConfirmPassword;
    Button btnSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtEmail = findViewById(R.id.txtEmailLogin);
        txtPassword = findViewById(R.id.txtPasswordLogin);
        txtPhone = findViewById(R.id.txtPhoneSignUp);
        txtAddress = findViewById(R.id.txtAddressSignUp);
        txtConfirmPassword = findViewById(R.id.txtConfirmPassword);

        btnSignUp = findViewById(R.id.btnLogin);

        btnSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSignUp) {
            btnSignUpClick();
        }
    }

    private void btnSignUpClick() {

    }
}
