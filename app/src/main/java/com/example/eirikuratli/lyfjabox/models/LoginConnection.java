package com.example.eirikuratli.lyfjabox.models;

import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;

/**
 * Created by EiríkurAtli on 3.4.2017.
 */

public class LoginConnection {
    private static final String TAG = "LoginConnection";
    public String sendLogin(User loggedinUser){
        try{

            String url = Uri.parse("http://10.0.2.2:8080/m/login/")
                    .buildUpon()
                    .build().toString();
            Gson gson = new Gson();
            String json = gson.toJson(loggedinUser);
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
