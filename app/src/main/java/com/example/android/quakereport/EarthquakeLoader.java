package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.example.android.quakereport.QueryUtils;
import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<word>> {
    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<word> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<word> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}