package com.example.eirikuratli.lyfjabox.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
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
import com.example.eirikuratli.lyfjabox.models.LoginConnection;
import com.example.eirikuratli.lyfjabox.models.LoginUser;
import com.example.eirikuratli.lyfjabox.models.RegisterConnection;
import com.example.eirikuratli.lyfjabox.models.User;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";
    private EditText mFirstName, mLastName, mSocial, mAddress, mUsername, mEmail, mPassword, mConfirmedPassword, mPhoneNo;
    private Spinner mZipSpinner;
    private Button mRegister;
    private User newUser;

    private UserRegistrationTask mAuthTask = null;

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

                attemptRegistration();
            }
        });
    }

    private void attemptRegistration() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmail.setError(null);
        mPassword.setError(null);

        // Store values at the time of the login attempt.
        newUser = createUser();

        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;


        AsyncTask task = new RegisterActivity.UserRegistrationTask().execute(newUser);
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserRegistrationTask extends AsyncTask<User, Void, String> {

        @Override
        protected String doInBackground(User... Users) {
            // TODO: attempt authentication against a network service.

            if(Users.length>0) {
                Log.i(TAG, Users.length+" er lengdin á Users " );
                Log.i(TAG, Users.toString());
                String message = new RegisterConnection().sendRegistration(Users[0]);
                return message;
            }
            return "Doesnt work, there is no user";
        }

        @Override
        protected void onPostExecute(String response){
            Log.d(TAG, response.toString());
            if("OK".equals(response)) {

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

                Toast toast = Toast.makeText(RegisterActivity.this ,"registration successful", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                Log.d(TAG, "GilmoreGirlsÁHomeScreen: " + mEmail.getText().toString());
                intent.putExtra("email", mEmail.getText().toString());
                startActivity(intent);
            }
            else {
                Log.e(TAG, "Error when handling json");
                Toast toast = Toast.makeText(RegisterActivity.this, "Sign up not successful, try again later", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }
        }
    }

    public User createUser() {
        User newUser = new User();
        newUser.setUsername(mEmail.getText().toString());
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
