package com.example.hostellife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {

    EditText fullname,address,collagename,email,mobile;
    Button insertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        //initializing variables
        fullname = findViewById(R.id.student_fullName_ID);
        address = findViewById(R.id.student_address_ID);
        collagename = findViewById(R.id.student_collage_ID);
        email = findViewById(R.id.student_email_ID);
        mobile = findViewById(R.id.student_contact_ID);
        insertBtn = findViewById(R.id.insertStudent_BTN_ID);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "HostelDatabase").allowMainThreadQueries().build();
                studentDao studentDao = db.studentDao();
                studentDao.insertAll(new StudentModel(fullname.getText().toString(),address.getText().toString(),email.getText().toString(),mobile.getText().toString()));
                Toast.makeText(AddStudent.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }
}