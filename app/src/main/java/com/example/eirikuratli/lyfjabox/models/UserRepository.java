package com.example.eirikuratli.lyfjabox.models;

import android.util.Log;

import com.example.eirikuratli.lyfjabox.models.ConnectionClass;
import com.example.eirikuratli.lyfjabox.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by EiríkurAtli on 21.3.2017.
 */



public class UserRepository {

    private ConnectionClass connectionClass;
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
