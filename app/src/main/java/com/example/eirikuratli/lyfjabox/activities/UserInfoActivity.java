package com.example.eirikuratli.lyfjabox.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.eirikuratli.lyfjabox.R;


public class UserInfoActivity extends AppCompatActivity {

        private Button mUpdateInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        mUpdateInfo = (Button) findViewById(R.id.update_button);
        mUpdateInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // to be implemented
            }
        });

    }


}
