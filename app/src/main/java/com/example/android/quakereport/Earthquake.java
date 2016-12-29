package com.example.android.quakereport;


public class Earthquake {

    private double mMagnitude;
    private String mPlace;
    private long mDate;

    public Earthquake(double magnitude, String place, long date) {
        this.mMagnitude = magnitude;
        this.mPlace = place;
        this.mDate = date;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getPlace() {
        return mPlace;
    }

    public long getDate() {
        return mDate;
    }
}
