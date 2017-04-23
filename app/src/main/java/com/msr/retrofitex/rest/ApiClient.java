package com.msr.retrofitex.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sandeep Maram on 23/4/2017.
 */
public class ApiClient {
    /*public static final String BASE_URL = "http://api.androidhive.info/";*/
    //public static final String BASE_URL = "http://api.geonames.org/";
    public static final String BASE_URL = "http://afrikabet.com/datajson/feed7.php/";
    public static final String OUR_BASE_URL = "http://www.totaltennisinfo.com/tennisapi/feed7.php/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
