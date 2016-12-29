package com.example.android.quakereport;


public class Earthquake {

    private double mMagnitude;
    private String mPlace;
    private long mDate;
    private String mUrl;

    public Earthquake(double magnitude, String place, long date, String url) {
        this.mMagnitude = magnitude;
        this.mPlace = place;
        this.mDate = date;
        this.mUrl = url;
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

    public String getUrl() {
        return mUrl;
    }
}
