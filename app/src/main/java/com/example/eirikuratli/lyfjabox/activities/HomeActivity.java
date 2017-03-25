package com.example.eirikuratli.lyfjabox.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.eirkuratli.lyfjabox.R;

public class HomeActivity extends AppCompatActivity {

    //TODO: Create methods for buttons, link them to other activites
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String name = getIntent().getStringExtra("firstName");
        TextView greetingText = (TextView) findViewById(R.id.greeting_user);
        String format = getString(R.string.greeting_home);
        greetingText.setText(String.format(format, name));

    }


}
