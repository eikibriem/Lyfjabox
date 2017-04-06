package com.example.eirikuratli.lyfjabox.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.eirikuratli.lyfjabox.R;
import com.example.eirikuratli.lyfjabox.models.Drug;


public class RegisterMedicineActivity extends AppCompatActivity {
    private TextView drugName;
    private EditText drugDosage;
    private Spinner drugFrequency;
    private Spinner drugReminder;
    private Spinner reminderTimeHour;
    private Spinner reminderTimeMinutes;
    private Button registerDrug;
    private Drug drug;

    //Activity that is a result of MedicineInfoActivity, will enable the user to register certain meds to his/her account
    //in dosage and frequency along with the option to get notifications from the app when it's time to take medication

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_medicine);

        drug = getIntent().getParcelableExtra("SelectedDrug");

        drugName = (TextView) findViewById(R.id.drug_name);
        drugName.setText(drug.getName());

        drugDosage = (EditText) findViewById(R.id.drug_dosage_input);
        drugFrequency = (Spinner) findViewById(R.id.drug_frequency_input);
        drugReminder = (Spinner) findViewById(R.id.drug_reminder_input);
        reminderTimeHour = (Spinner) findViewById(R.id.time_hour_input);
        reminderTimeMinutes = (Spinner) findViewById(R.id.time_minute_input);

        registerDrug = (Button) findViewById(R.id.button_drug_registration_finished);
        registerDrug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: save to database
                Toast.makeText(v.getContext(), "Registration success", Toast.LENGTH_LONG).show();
                finish();
            }
        });


    }
}
