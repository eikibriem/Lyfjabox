package com.example.eirikuratli.lyfjabox.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eirikuratli.lyfjabox.R;


public class HomeActivity extends AppCompatActivity {
    //The main activity in the app after logging in, does not do anything besides linking to other
    //activities and display a user greeting.

    SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        shared = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        String name = shared.getString("firstname", "user");

        //String name = getIntent().getStringExtra("firstName");
        TextView greetingText = (TextView) findViewById(R.id.greeting_user);
        String format = getString(R.string.greeting_home);
        greetingText.setText(String.format(format, name));

        Button mSearch = (Button) findViewById(R.id.search_meds_button);
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        Button mFindPharmacy = (Button) findViewById(R.id.search_pharmacy_button);
        mFindPharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
        //Fix with userinfoactivity class when pushed
        Button mUserInfo = (Button) findViewById(R.id.user_information_button);
        mUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });

        Button mViewMeds = (Button) findViewById(R.id.registered_meds_button);
        mViewMeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MedicineOverviewActivity.class);
                startActivity(intent);
            }
        });

//TODO: Create logout method, this will only direct the user to the WelcomeActivity but not log out
        TextView mLogOut = (TextView) findViewById(R.id.log_out);
        mLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


}
