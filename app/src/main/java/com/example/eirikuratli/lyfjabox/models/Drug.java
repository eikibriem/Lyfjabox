package com.example.eirikuratli.lyfjabox.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.Date;

/**
 * Created by thorunn on 22/03/17.
 */

public class Drug implements Comparable<Drug>, Parcelable {
    private int id;
    private double dose;
    private int frequency;
    private Date date;
    private String name;
    private String activeIngr;
    private boolean reminder;
    // HH:MM:SS
    private String reminderTime;

    public Drug() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActiveIngr() {
        return activeIngr;
    }

    public void setActiveIngr(String activeIngr) {
        this.activeIngr = activeIngr;
    }

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

    public String getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(String reminderTime) {
        this.reminderTime = reminderTime;
    }

    @Override
    public int compareTo(@NonNull Drug o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeDouble(dose);
        dest.writeInt(frequency);
        dest.writeString(name);
        dest.writeString(activeIngr);
        dest.writeByte((byte) (reminder ? 1 : 0));
        dest.writeString(reminderTime);
    }

    protected Drug(Parcel in) {
        id = in.readInt();
        dose = in.readDouble();
        frequency = in.readInt();
        name = in.readString();
        activeIngr = in.readString();
        reminder = in.readByte() != 0;
        reminderTime = in.readString();
    }

    public static final Creator<Drug> CREATOR = new Creator<Drug>() {
        @Override
        public Drug createFromParcel(Parcel in) {
            return new Drug(in);
        }

        @Override
        public Drug[] newArray(int size) {
            return new Drug[size];
        }
    };
}
