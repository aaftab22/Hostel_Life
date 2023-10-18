package com.darksunTechnologies.hostellife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateDataStaff extends AppCompatActivity {
    EditText fullnameET,addressET,emailET,mobilenoET;
    int updateID;
    Button updateBTN2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data_staff);
        fullnameET = findViewById(R.id.staff_UfullName_ID);
        addressET = findViewById(R.id.staff_Uaddress_ID);
        emailET = findViewById(R.id.staff_Uemail_ID);
        mobilenoET = findViewById(R.id.staff_Ucontact_ID);
        updateBTN2 = findViewById(R.id.updateStaff_BTN_ID);

        updateID = Integer.parseInt(getIntent().getStringExtra("sID"));
        fullnameET.setText(getIntent().getStringExtra("fullname"));
        addressET.setText(getIntent().getStringExtra("address"));
        emailET.setText(getIntent().getStringExtra("email"));
        mobilenoET.setText(getIntent().getStringExtra("contact"));

        updateBTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "hostelStaffDatabase").allowMainThreadQueries().build();
                staffDao staffDao = db.staffDao();
                staffDao.updateById(updateID,fullnameET.getText().toString(),addressET.getText().toString(),emailET.getText().toString(),mobilenoET.getText().toString());
                Toast.makeText(updateDataStaff.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });


    }
}