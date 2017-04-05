package com.example.eirikuratli.lyfjabox.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.eirikuratli.lyfjabox.R;
import com.example.eirikuratli.lyfjabox.models.RegisterConnection;
import com.example.eirikuratli.lyfjabox.models.User;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";
    private EditText mFirstName, mLastName, mSocial, mAddress, mUsername, mEmail, mPassword, mConfirmedPassword, mPhoneNo;
    private Spinner mZipSpinner;
    private Button mRegister;

    SharedPreferences shared;

    //User registration class, user signs up for the service

//TODO: Connect class to user service class so the information can be used to create users

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirstName = (EditText) findViewById(R.id.first_name_input);
        mLastName = (EditText) findViewById(R.id.last_name_input);
        mSocial = (EditText) findViewById(R.id.ssn_input);
        mAddress = (EditText) findViewById(R.id.address_input);
        mPhoneNo = (EditText) findViewById(R.id.phone_input);
        mEmail = (EditText) findViewById(R.id.email_input);
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

                User newUser = createUser();
                Log.i(TAG, newUser.getFirstName());

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

                String message = new RegisterConnection().sendRegistration(newUser);
                Log.i(TAG, message);

                if (message.contains("Account already created")) {
                    Toast toast = Toast.makeText(RegisterActivity.this ,message, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                if (message.contains("complete")) {
                    shared =getSharedPreferences("UserInfo", MODE_PRIVATE);

                    SharedPreferences.Editor editor = shared.edit();
                    editor.putString("firstname", newUser.getFirstName());
                    editor.putString("lastname", newUser.getLastName());
                    editor.putString("address", newUser.getAddress());
                    editor.putString("city", newUser.getCity());
                    editor.putString("email", newUser.getEmail());
                    editor.putString("password", newUser.getPassword());
                    editor.putInt("phoneNo", newUser.getPhoneNo());
                    editor.putInt("ssn", newUser.getSocial());
                    editor.putInt("zip", newUser.getZip());
                    editor.putString("username", newUser.getUsername());
                    editor.commit();

                    Log.i(TAG, "what????");

                    Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                    startActivity(intent);
                }

                else {
                    Toast toast = Toast.makeText(RegisterActivity.this ,"Problem connecting to database", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });
    }
    public User createUser() {
        User newUser = new User();
        newUser.setFirstName(mFirstName.getText().toString());
        newUser.setLastName(mLastName.getText().toString());
        newUser.setEmail(mEmail.getText().toString());
        newUser.setAddress(mAddress.getText().toString());
        Log.i(TAG, "Hérna er símanúmerið: "+mPhoneNo.getText().toString());
        newUser.setPhoneNo(Integer.parseInt(mPhoneNo.getText().toString()));
        newUser.setSocial(Integer.parseInt(mSocial.getText().toString()));
        newUser.setPassword(mPassword.getText().toString());

        String zipCity = mZipSpinner.getSelectedItem().toString();
        newUser.setZip(Integer.parseInt(zipCity.substring(0,3)));
        newUser.setCity(zipCity.substring(4));

        return newUser;
    }
}
