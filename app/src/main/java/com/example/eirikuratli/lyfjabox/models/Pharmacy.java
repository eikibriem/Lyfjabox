package com.example.eirikuratli.lyfjabox.models;

/**
 * Created by thorunn on 22/03/17.
 */

public class Pharmacy {
    private int id;
    private String name;
    private String address;
    private String zip;
    private String phoneNo;
    private double longitude;
    private double latitude;
    private String opHours;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public String getOpHours() {
        return opHours;
    }

    public void setOpHours(String opHours) {
        this.opHours = opHours;
    }
}
