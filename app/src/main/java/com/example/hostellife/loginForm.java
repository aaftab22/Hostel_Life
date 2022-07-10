package com.example.hostellife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class loginForm extends AppCompatActivity {
    Button loginBTN;
    EditText email,password;
    TextView error2TV,forgetPasswordTV;
    ImageView eyeBTN;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        getSupportActionBar().hide();

        //initialization 
        email = findViewById(R.id.signIn_email_ID);
        password = findViewById(R.id.signIn_password_ID);
        error2TV = findViewById(R.id.invalidPassword);
        eyeBTN  = findViewById(R.id.password_hide_icon_ID);
        forgetPasswordTV = findViewById(R.id.forget_password_id);
        loginBTN = findViewById(R.id.login_btn_ID);
        firebaseAuth = FirebaseAuth.getInstance();

        //to make password visible in the password field
        eyeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password.setTransformationMethod(null);
            }
        });

        //to verify login credential to login a admin
        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    startActivity(new Intent(loginForm.this,MainActivity.class));
                                    finish();
                                }
                                else
                                {
                                    error2TV.setText(R.string.wrong_password_text);
                                    String err = task.getException().getMessage();
                                    Toast.makeText(loginForm.this, err, Toast.LENGTH_SHORT).show();
                                }
                        }
                });
            }
        });

        //to reset your password through Email
        forgetPasswordTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.signIn_email_ID);
                String emailId = textView.getText().toString();
                Intent forgetPassIntent = new Intent(loginForm.this,forgetPasswordActivity.class);
                forgetPassIntent.putExtra("emailId",emailId);
                startActivity(forgetPassIntent);
            }
        });

    }
}

