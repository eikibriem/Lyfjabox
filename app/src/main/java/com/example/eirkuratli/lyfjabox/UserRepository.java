package com.example.eirkuratli.lyfjabox;

import android.database.sqlite.SQLiteDatabase;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by EiríkurAtli on 21.3.2017.
 */



public class UserRepository {

    ConnectionClass connectionClass;
    //database : SQLiteDatabase;
    //dbHelper : MySQLiteHelper;

    public User doLogin(String email, String password) throws SQLException {
        User user = new User();
        ResultSet rs;
        Log.d("Mytag","UserRepository failure");

        try {
            Connection con = connectionClass.CONN();
            if (con == null) {
                Log.d("Mytag","Error in connection with SQL server");
            } else {
                String query = "select * from userdata where email='" + email + "' and password='" + password + "'";
                Statement stmt = null;
                try {
                    stmt = con.createStatement();
                    Log.d("Mytag","UserRepository stmt failure");

                } catch (SQLException e) {
                    e.printStackTrace();
                    Log.d("Mytag","UserRepository SQLExeption failure");

                }
                try {
                    rs = stmt.executeQuery(query);
                    Log.d("Mytag","UserRepository rs failure");

                } catch (SQLException e) {
                    e.printStackTrace();
                    Log.d("Mytag", "UserRepository later SQLException failure");

                }
            }
            return user;
        }



        catch (Exception ex)
        {
            System.out.println("UserRepository.java Exception í doLogin");
            return null;
        }
    }

    // findByName(name : String) : List<User>
    // findByUsername(username : Sting) : List<User>

}
