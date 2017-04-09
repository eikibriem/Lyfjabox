package com.example.eirikuratli.lyfjabox.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Spinner;
import android.content.Context;

import com.example.eirikuratli.lyfjabox.R;
import com.example.eirikuratli.lyfjabox.models.RegisterConnection;
import com.example.eirikuratli.lyfjabox.models.User;


public class UserActivity extends AppCompatActivity {
    private static final String TAG = "UserActivity";
        private EditText mFirstName, mLastName, mSocial, mAddress, mUsername, mEmail, mPassword, mConfirmedPassword, mPhoneNo;
        private Spinner mZipSpinner;

        SharedPreferences shared;


    private Button mUpdate;
        private Button mCancelUpdate;
        private User editedUser;

        private UserActivity.UserEditedTask mAuthTask = null;

    // User information class, user can edit his personal information

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        shared = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        String name = shared.getString("firstname", "user");
        String lastname = shared.getString("lastname", "user");

        TextView greeting = (TextView) findViewById(R.id.user_greeting);
        String format = getString(R.string.user_greeting);

        greeting.setText(String.format(format, name+ " " + lastname));


        mFirstName = (EditText) findViewById(R.id.first_name_edit);
        mFirstName.setText(shared.getString("firstname", "Anonymous"), TextView.BufferType.EDITABLE);
        mLastName = (EditText) findViewById(R.id.last_name_edit);
        mLastName.setText(shared.getString("lastname", "Last name"), TextView.BufferType.EDITABLE);
        mSocial = (EditText) findViewById(R.id.ssn_edit);
        //mSocial.setText(shared.getInt("ssn", Integer.parseInt("1234")), TextView.BufferType.EDITABLE);
        mAddress = (EditText) findViewById(R.id.address_edit);
        mAddress.setText(shared.getString("address", "Address"), TextView.BufferType.EDITABLE);
        //mEmail = (EditText) findViewById(R.id.email_edit);
        //mEmail.setText(shared.getString("email", "Email"), TextView.BufferType.EDITABLE);
        mUsername = (EditText) findViewById(R.id.email_edit);
        mUsername.setText(shared.getString("username", null), TextView.BufferType.EDITABLE);
        mPassword = (EditText) findViewById(R.id.password_edit);
        mPassword.setText(shared.getString("password", null), TextView.BufferType.EDITABLE);
        mConfirmedPassword = (EditText) findViewById(R.id.password_repeat_edit);
        mConfirmedPassword.setText(shared.getString("password", null), TextView.BufferType.EDITABLE);
        mZipSpinner = (Spinner) findViewById(R.id.zip_edit);
        mPhoneNo = (EditText) findViewById(R.id.phone_edit);
        //mPhoneNo.setText(shared.getInt("phoneNo",5812345 ), TextView.BufferType.EDITABLE);


        Button mCancelUpdate = (Button) findViewById(R.id.cancel_update_button);
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

                attemptEditUser();
            }
        });

    }

    private void attemptEditUser() {
            if(mAuthTask !=null) {
                return;
            }

            // Reset errors
            mEmail.setError(null);
            mPassword.setError(null);

            // Store values at the time of the login attempt.
            editedUser = editedUser();

            String email = mEmail.getText().toString();
            String password = mPassword.getText().toString();

            boolean cancel = false;
            View focusView = null;

            // laga userReg Task
            AsyncTask task = new UserActivity.UserEditedTask().execute(editedUser);

    }

        public class UserEditedTask extends AsyncTask<User, Void, String> {

            @Override
            protected String doInBackground(User... Users) {
                // TODO: attempt authentication against a network service.

                if (Users.length > 0) {
                    Log.i(TAG, Users.length + " er lengdin á Users ");
                    Log.i(TAG, Users.toString());
                    String message = new RegisterConnection().sendRegistration(Users[0]);
                    return message;
                }
                return "Doesnt work, there is no user";
            }

            @Override
            protected void onPostExecute(String response) {
                Log.d(TAG, response.toString());
                if ("OK".equals(response)) {

                    shared = getSharedPreferences("UserInfo", MODE_PRIVATE);

                    SharedPreferences.Editor editor = shared.edit();
                    editor.putString("firstname", editedUser.getFirstName());
                    editor.putString("lastname", editedUser.getLastName());
                    editor.putString("address", editedUser.getAddress());
                    editor.putString("city", editedUser.getCity());
                    editor.putString("email", editedUser.getEmail());
                    editor.putString("password", editedUser.getPassword());
                    editor.putInt("phoneNo", editedUser.getPhoneNo());
                    editor.putInt("ssn", editedUser.getSocial());
                    editor.putInt("zip", editedUser.getZip());
                    editor.putString("username", editedUser.getUsername());
                    editor.apply();

                    Toast toast = Toast.makeText(UserActivity.this, "@string/update_successful_toast", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Intent intent = new Intent(UserActivity.this, HomeActivity.class);
                    Log.d(TAG, "GilmoreGirlsÁHomeScreen: " + mEmail.getText().toString());
                    intent.putExtra("email", mEmail.getText().toString());
                    startActivity(intent);
                }
                else {
                    Log.e(TAG, "Error when handling json");
                    Toast toast = Toast.makeText(UserActivity.this, "Edit not successful, try again later", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        }

    public User editedUser() {
        User editedUser = new User();
        editedUser.setFirstName(mFirstName.getText().toString());
        editedUser.setLastName(mLastName.getText().toString());
        editedUser.setEmail(mEmail.getText().toString());
        editedUser.setAddress(mAddress.getText().toString());
        Log.i("TAG", "Hérna er símanúmerið: "+mPhoneNo.getText().toString());
        editedUser.setPhoneNo(Integer.parseInt(mPhoneNo.getText().toString()));
        editedUser.setSocial(Integer.parseInt(mSocial.getText().toString()));
        editedUser.setPassword(mPassword.getText().toString());

        String zipCity = mZipSpinner.getSelectedItem().toString();
        editedUser.setZip(Integer.parseInt(zipCity.substring(0,3)));
        editedUser.setCity(zipCity.substring(4));

        return editedUser;
    }

}


