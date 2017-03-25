package com.example.eirikuratli.lyfjabox.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.eirkuratli.lyfjabox.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText mFirstName, mLastName, mSocial, mAddress, mUsername, mPassword, mConfirmedPassword;
    private Spinner mZipSpinner;
    private Button mRegister;
//TODO: Connect class to user service class so the information can be used to create users

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirstName = (EditText) findViewById(R.id.first_name_input);
        mLastName = (EditText) findViewById(R.id.last_name_input);
        mSocial = (EditText) findViewById(R.id.ssn_input);
        mAddress = (EditText) findViewById(R.id.address_input);
        mUsername = (EditText) findViewById(R.id.email_input);
        mPassword = (EditText) findViewById(R.id.password_input);
        mConfirmedPassword = (EditText) findViewById(R.id.password_repeat_input);

        mZipSpinner = (Spinner) findViewById(R.id.zip_input);

        Button mCancel = (Button) findViewById(R.id.cancel_button);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
                startActivity(intent);
            }
        });

        mRegister = (Button) findViewById(R.id.sign_up_button);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

                if (mPassword.getText().toString().equals(mConfirmedPassword.getText().toString())) {
                    String password = mPassword.getText().toString();
                } else {
                    mPassword.setError("Passwords do not match");
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
            }
        });
    }
}
