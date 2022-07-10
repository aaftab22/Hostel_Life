package com.example.hostellife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class registerActivity extends AppCompatActivity {
    EditText fullName, email , password, confirmPassword;
    TextView alreadyHaveAnAccount;
    Button signupBtn;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //to hide actionbar
        getSupportActionBar().hide();

        //initialization
        fullName = findViewById(R.id.signUp_name_ID);
        email = findViewById(R.id.signUp_email_ID);
        password = findViewById(R.id.signUp_password_ID);
        confirmPassword = findViewById(R.id.signUp_confirmPassword_ID);
        signupBtn = findViewById(R.id.signUp_submitBtn_ID);
        alreadyHaveAnAccount = findViewById(R.id.already_have_account_ID);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        //to sent data to firebase
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    Map<Object,String> userdata = new HashMap<>();
                                    userdata.put("fullName",fullName.getText().toString());
                                    firebaseFirestore.collection("ADMIN")
                                        .add(userdata)
                                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                        @Override
                                        public void onComplete(@NonNull Task<DocumentReference> task) {
                                        if (task.isSuccessful())
                                        {
                                        Intent mainIntent = new Intent(registerActivity.this,MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                        }
                                        else {
                                            String err = task.getException().getMessage();
                                            Toast.makeText(registerActivity.this, err, Toast.LENGTH_SHORT).show();
                                        }
                                        }
                                            });
                                }
                                else
                                {
                                    String err = task.getException().getMessage();
                                    Toast.makeText(registerActivity.this, err, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                }
        });

        //to login directly
        alreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(registerActivity.this,loginForm.class));
            }
        });

    }
}