package com.example.eirikuratli.lyfjabox.models;

/**
 * Created by EiríkurAtli on 4.4.2017.
 */

public class LoginUser {

    public LoginUser() {

    }

    private String email;
    private String password;

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String userName){
        this.email = userName;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
