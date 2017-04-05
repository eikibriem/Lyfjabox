package com.example.eirikuratli.lyfjabox.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.eirikuratli.lyfjabox.R;
import com.example.eirikuratli.lyfjabox.models.Drug;


public class MedicineInfoActivity extends AppCompatActivity {
    //Activity where the user can see information about the medicine he/she has looked up in the SearchActivity
    //Will display warnings if medicine can interfere with already registered medication
    private static final String TAG = MedicineInfoActivity.class.getSimpleName();
    private Drug drug;
    private TextView mDrugName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_info);

        drug = getIntent().getParcelableExtra("SelectedDrug");

        mDrugName = (TextView) findViewById(R.id.drug_name);
        mDrugName.setText(drug.getName());
    }
}
