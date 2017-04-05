package com.example.eirikuratli.lyfjabox.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TimePicker;

import com.example.eirikuratli.lyfjabox.R;


public class RegisterMedicineActivity extends AppCompatActivity {

    private TimePicker timePicker1;
    //Activity that is a result of MedicineInfoActivity, will enable the user to register certain meds to his/her account
    //in dosage and frequency along with the option to get notifications from the app when it's time to take medication

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_medicine);

    }
}
