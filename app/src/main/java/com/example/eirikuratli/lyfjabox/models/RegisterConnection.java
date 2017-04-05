package com.example.eirikuratli.lyfjabox.models;

import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;

/**
 * Created by EiríkurAtli on 5.4.2017.
 */

public class RegisterConnection {
    private static final String TAG = "RegisterConnection";
    public String sendRegistration(User newUser) {
        try {
            String url = Uri.parse("http://10.0.2.2:8080/m/register/")
                    .buildUpon()
                    .build().toString();
            Gson gson = new Gson();
            String json = gson.toJson(newUser);
            Log.i(TAG, "RegisterJSON er" + json);
            String response = PostData.postData(url, json);

            Log.i(TAG, "Received response:" + response);
            return response;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "Doesn't work";
    }

}
