package com.darksunTechnologies.hostellife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateData extends AppCompatActivity {
    EditText fullnameET,addressET,emailET,mobilenoET;
    int updateID;
    Button updateBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        fullnameET = findViewById(R.id.student_UfullName_ID);
        addressET = findViewById(R.id.student_Uaddress_ID);
        emailET = findViewById(R.id.student_Uemail_ID);
        mobilenoET = findViewById(R.id.student_Ucontact_ID);
        updateBTN = findViewById(R.id.updateStudent_BTN_ID);


            updateID = Integer.parseInt(getIntent().getStringExtra("sID"));
            fullnameET.setText(getIntent().getStringExtra("fullname"));
            addressET.setText(getIntent().getStringExtra("address"));
            emailET.setText(getIntent().getStringExtra("email"));
            mobilenoET.setText(getIntent().getStringExtra("contact"));

        updateBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "HostelDatabase").allowMainThreadQueries().build();
                studentDao studentDao = db.studentDao();
                studentDao.updateById(updateID,fullnameET.getText().toString(),addressET.getText().toString(),emailET.getText().toString(),mobilenoET.getText().toString());
                Toast.makeText(updateData.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }


        });

    }
}