package com.example.android.quakereport;

/**
 * Created by Justas on 11/19/2017.
 */

public class word {
    private double Mmag;
    private String Mcity;
    private String mUrl;
    private long Mdate;
    public word (double mag, String city, long date,String url)
    {
        Mmag=mag;
        Mcity=city;
        Mdate=date;
        mUrl=url;
    }
    public double getMag(){return Mmag;}

    public String getCity(){return Mcity;}

    public String getUrl() {return mUrl;}

    public long getDate(){return Mdate;}

}
