package com.example.eirikuratli.lyfjabox.models;

import android.util.Log;

import com.example.eirikuratli.lyfjabox.models.User;
import com.example.eirikuratli.lyfjabox.models.UserRepository;

import java.sql.SQLException;

/**
 * Created by EiríkurAtli on 21.3.2017.
 */

public class UserService {

    UserRepository repository = new UserRepository();

    public User doLogin(String email, String password) throws SQLException {
        try {
            Log.d("Mytag","UserService try failure");
            return repository.doLogin(email, password);
        } catch (SQLException e) {
            Log.d("Mytag","UserService catch failure");
            e.printStackTrace();
        }
        return null;
    }
}
