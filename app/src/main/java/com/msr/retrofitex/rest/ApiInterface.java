package com.msr.retrofitex.rest;

import com.msr.retrofitex.model.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Sandeep Maram on 23/4/2017.
 */
public interface ApiInterface {
    @GET(ApiClient.OUR_BASE_URL)
    Call<Model> getLiveMatches(@Query("type") String type);
}
