package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

public class EarthquakeLoader extends AsyncTaskLoader<ArrayList<Earthquake>> {

    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    @Override
    public ArrayList<Earthquake> loadInBackground() {

        ArrayList<Earthquake> earthquakes = null;

        if (mUrl == null) {
            return null;
        }

        Log.v(EarthquakeLoader.class.getSimpleName(), "loadInBackground");
        return QueryUtils.extractEarthquakes(QueryUtils.createUrl(mUrl));
    }


    @Override
    protected void onStartLoading() {
        Log.v(EarthquakeLoader.class.getSimpleName(), "On start loading");
        forceLoad();
    }
}