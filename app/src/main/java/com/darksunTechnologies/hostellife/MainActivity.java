package com.darksunTechnologies.hostellife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.bnv_id);
        //customization of action bar
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#0F9D58"));
        actionBar.setBackgroundDrawable(colorDrawable);

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new HomeFragment()).commit();

        view.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fr = null;
                switch (item.getItemId()) {
                    case R.id.homeMenu_ID:
                        actionBar.setTitle("Hostel Life");
                        fr = new HomeFragment();
                        break;
                    case R.id.studentMenu_ID:
                        actionBar.setTitle("Student Details");
                        fr = new StudentFragment();
                        break;
                    case R.id.staffMenu_ID:
                        actionBar.setTitle("Staff Details");
                        fr = new StaffFragment();
                        break;
                    case R.id.profileMenu_ID:
                        actionBar.setTitle("Hostel Life");
                        fr = new ProfileFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, fr).commit();
                return true;
            }
        });
    }
}