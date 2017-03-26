package com.example.eirikuratli.lyfjabox.models;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by EiríkurAtli on 21.3.2017.
 */

public class ConnectionClass {

    String classs = "org.postgresql.Driver";
    String hostName = "localhost";
    String port = "5432";
    String db ="HBV";
    //String db = "Andro";
    String un = "postgres";
    String password = "nufc";


/*
    String classs = "org.postgresql.Driver";
    String hostName = "ec2-174-129-29-118.compute-1.amazonaws.com";
    String port = "5432";
    String db ="d15m5640ih7gen?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    //String db = "Andro";
    String un = "jhqeymjpexdoqy";
    String password = "SXcbqtqdVInNzUCON9glAeahE_";
*/
    @SuppressLint("NewApi")
    public Connection CONN() {
        //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
        //        .permitAll().build();
        //StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {

            Class.forName("org.postgresql.Driver");

            ConnURL = "jdbc:postgresql://localhost:5432/HBV";
            Properties props = new Properties();
            props.setProperty("user","postgres");
            props.setProperty("password","nufc");
            props.setProperty("ssl","true");
            conn = DriverManager.getConnection(ConnURL, props);
            Log.d("MyTag", "Connection successful!!!!!!!!!");

        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;
    }
}