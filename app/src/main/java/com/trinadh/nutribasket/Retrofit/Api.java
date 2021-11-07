package com.trinadh.nutribasket.Retrofit;


import retrofit.RestAdapter;

/**
 * Created by AbhiAndroid
 */
public class Api {

    public static final String BASE_URL = "http://nutriplusbasket.com";

    public static ApiInterface getClient() {

        // change your base URL
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://nutriplusbasket.com") //Set the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        ApiInterface api = adapter.create(ApiInterface.class);
        return api;
    }
}
