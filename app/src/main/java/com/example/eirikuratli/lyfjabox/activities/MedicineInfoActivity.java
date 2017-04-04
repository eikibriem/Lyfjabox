package com.example.eirikuratli.lyfjabox.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.eirikuratli.lyfjabox.R;
import com.example.eirikuratli.lyfjabox.models.Drug;


public class MedicineInfoActivity extends AppCompatActivity {
    //Activity where the user can see information about the medicine he/she has looked up in the SearchActivity
    //Will display warnings if medicine can interfere with already registered medication
    private static final String TAG = MedicineInfoActivity.class.getSimpleName();
    private Drug drug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_info);

        drug = getIntent().getParcelableExtra("SelectedDrug");

        Log.d(TAG, "The drug selected was: " + drug.getName());
    }
}
