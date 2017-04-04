package com.example.eirikuratli.lyfjabox.models;

/**
 * Created by EiríkurAtli on 4.4.2017.
 */

public class LoginUser {

    public LoginUser() {

    }

    private String userName;
    private String password;

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
