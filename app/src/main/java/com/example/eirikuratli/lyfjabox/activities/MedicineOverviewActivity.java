package com.example.eirikuratli.lyfjabox.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.eirikuratli.lyfjabox.R;


public class MedicineOverviewActivity extends AppCompatActivity {
//Activity for viewing all registered medication along with the option of editing the registration (example: turn notifications on or off).
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_overview);
    }
}
