package com.example.eirikuratli.lyfjabox.models;

/**
 * Created by thorunn on 22/03/17.
 */

public class User {

    private String firstName;
    private String lastName;
    private String userName;


    public User(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
