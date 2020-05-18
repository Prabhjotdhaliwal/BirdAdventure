package com.example.birdsadventure;

import android.content.Intent;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth fireBaseAuth;
    //FirebaseFirestore fstore;
    EditText txtName, txtEmail, txtPassword, txtPhone, txtAddress, txtConfirmPassword;
    Button btnSignUp,newSIgnupbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_sign_up);

        txtName = findViewById (R.id.txtNameSignUp);
        txtEmail = findViewById (R.id.txtEmailSignUp);
        txtPassword = findViewById (R.id.txtPasswordSignUp);
        txtPhone = findViewById (R.id.txtPhoneSignUp);
        txtAddress = findViewById (R.id.txtAddressSignUp);
        txtConfirmPassword = findViewById (R.id.txtConfirmPassword);


        //Initalize  firebaseAuth
        fireBaseAuth = FirebaseAuth.getInstance();
        btnSignUp = findViewById (R.id.btnSignUp);

        btnSignUp.setOnClickListener (this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId () == R.id.btnSignUp) {
           // btnSignUpClick ();
            registerUser ();
        }
    }

    private void btnSignUpClick() {



    }

//Register user Using Firebase Authentication
    private  void registerUser() {

        String namestr, emailstr, phonestr, addressstr, passwordstr, confirmpasswordstr;
        namestr = txtName.getText ().toString ().trim ();
        emailstr = txtEmail.getText ().toString ().trim ();
        phonestr = txtPhone.getText ().toString ().trim ();
        addressstr = txtAddress.getText ().toString ();
        passwordstr = txtPassword.getText ().toString ().trim ();
        confirmpasswordstr = txtConfirmPassword.getText ().toString ();


//check if the fields are empty
        if (TextUtils.isEmpty(namestr))
        {
            txtName.setError("Name is Required ");
        }
        if (TextUtils.isEmpty(emailstr))
        {
            txtEmail.setError("Email is Required ");

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailstr).matches())
        {
            txtEmail.setError("Enter a valid Email");

        }
        if (TextUtils.isEmpty(phonestr))
        {
            txtPhone.setError("Phone is Required ");

        }
        if (TextUtils.isEmpty(addressstr))
        {
            txtAddress.setError("Name is Required ");
        }
        if (TextUtils.isEmpty(passwordstr))
        {
            txtPassword.setError("Password is Required ");

        }
        if (passwordstr.length() < 8)
        {
            txtPassword.setError("Password must be >= 6 Characters");
        }
        if (TextUtils.isEmpty(confirmpasswordstr))
        {
            txtConfirmPassword.setError("Name is Required ");
        }

if (!confirmpasswordstr.equals (passwordstr) || confirmpasswordstr ==null)
{
    txtConfirmPassword.setError("Confirm Password  is not matched with password ");

}
        else {
            //create the user with email and password
            fireBaseAuth.createUserWithEmailAndPassword(emailstr, passwordstr)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("TAG", "createUserWithEmail:success");
                                Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();
                                FirebaseFirestore db = FirebaseFirestore.getInstance();

                                String name=txtName.getText().toString();
                                String Email=txtEmail.getText().toString();
                                String address=txtAddress.getText ().toString ();
                                String phone=txtPhone.getText().toString();

                                HashMap<String,String> user=new HashMap<>();
                                user.put("name",name);
                                user.put("Email",Email);
                                user.put ("address",address);
                                user.put("phone",phone);

                                db.collection("Users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>()
                                {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference)
                                    {
                                        Toast.makeText(SignUpActivity.this,"Added",Toast.LENGTH_SHORT).show();


                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e)
                                    {
                                        Toast.makeText(SignUpActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                                        e.printStackTrace();


                                    }
                                });

                                startActivity(new Intent(SignUpActivity.this, HomeActivity.class));

                            }
                        }
                    });
        }
    }



}