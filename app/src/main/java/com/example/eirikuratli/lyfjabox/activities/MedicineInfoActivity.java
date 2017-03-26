package com.example.eirikuratli.lyfjabox.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.eirkuratli.lyfjabox.R;

public class MedicineInfoActivity extends AppCompatActivity {
    //Activity where the user can see information about the medicine he/she has looked up in the SearchActivity
    //Will display warnings if medicine can interfere with already registered medication

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_info);
    }
}
