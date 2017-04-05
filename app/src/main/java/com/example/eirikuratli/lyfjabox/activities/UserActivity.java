package com.example.eirikuratli.lyfjabox.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Spinner;

import com.example.eirikuratli.lyfjabox.R;


public class UserActivity extends AppCompatActivity {
        private EditText mFirstName, mLastName, mSocial, mAddress, mUsername, mPassword, mConfirmedPassword;
        private Spinner mZipSpinner;
        private Button mUpdate;
        private Button mCancelUpdate;

    // User information class, user can edit his personal information

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // ath beint úr register, þarf að breyta first_name_input....

        mFirstName = (EditText) findViewById(R.id.first_name_input);
        mLastName = (EditText) findViewById(R.id.last_name_input);
        mSocial = (EditText) findViewById(R.id.ssn_input);
        mAddress = (EditText) findViewById(R.id.address_input);
        mUsername = (EditText) findViewById(R.id.email_input);
        mPassword = (EditText) findViewById(R.id.password_input);

        mCancelUpdate = (Button) findViewById(R.id.cancel_update_button);
        mCancelUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });

        mUpdate= (Button) findViewById(R.id.update_button);
        mUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // to be implemented
                mPassword.setError(null);
                String firstName = mFirstName.getText().toString();
                String lastName = mLastName.getText().toString();
                String socialNr = mSocial.getText().toString();
                String address = mAddress.getText().toString();
                String zipCode = mZipSpinner.getSelectedItem().toString();
                String userName = mUsername.getText().toString();

                if ((TextUtils.isEmpty(mPassword.getText().toString())) || (TextUtils.isEmpty(mConfirmedPassword.getText().toString())))  {
                    mPassword.setError("Password cannot be empty");
                }

                if (TextUtils.isEmpty(firstName)) {
                    mFirstName.setError("First name cannot be empty");
                }

                if (TextUtils.isEmpty(lastName)) {
                    mLastName.setError("Last name cannot be empty");
                }

                if (TextUtils.isEmpty(socialNr)) {
                    mSocial.setError("Social security number cannot be empty");
                }

                if (TextUtils.isEmpty(userName)) {
                    mUsername.setError("Email is not valid");
                }
                // "You successfully updated your user information!
                Toast.makeText(UserActivity.this, R.string.update_successful_toast, Toast.LENGTH_SHORT).show();

            }
        });

    }



}
