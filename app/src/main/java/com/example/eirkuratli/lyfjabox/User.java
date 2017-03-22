package com.example.eirkuratli.lyfjabox;


//import java.util.List;

/**
 * Created by EiríkurAtli on 3.11.2016.
 *
 */

public class User {

    private Long id;

    private String firstName;
    private String lastName;
    private int social;
    private String address;
    private String city;
    private int zip;
    private int phoneNo;
    private String email;
    private String username;
    private String password;
    private int accountType;
    private int loginCounter;
    private String[] userDrugs;

    public User() {
    }

    public User(String firstName, String lastName, int social, String address, String city, int zip, int phoneNo,
                    String email, String username, String password, int accountType, int loginCounter, String[] userDrugs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.social = social;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phoneNo = phoneNo;
        this.email = email;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
        this.loginCounter = loginCounter;
        this.userDrugs = userDrugs;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public String[] getUserDrugs() { return userDrugs; }

    public void setUserDrugs(String[] userDrugs) { this.userDrugs = userDrugs; }

    public int getLoginCounter() { return loginCounter; }

    public void setLoginCounter(int loginCounter) { this.loginCounter = loginCounter; }

/*
    @OneToMany(mappedBy = "userDrug", cascade = CascadeType.ALL)
    public Set<UserDrug> getUserDrugs() {
        return userDrugs;
    }

    public void setUserDrugs(Set<UserDrug> userDrugs) {
        this.userDrugs = userDrugs;
    }


    public int getLoginCounter() {
        return loginCounter;
    }

    public void setLoginCounter(int loginCounter) {
        this.loginCounter = loginCounter;
    }
*/


    @Override
    public String toString() {
        return String.format(
                "User Data[firstname=%s, lastname=%s]",
                firstName,lastName);
    }
}



