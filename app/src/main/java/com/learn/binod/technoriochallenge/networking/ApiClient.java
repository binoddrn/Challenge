package com.learn.binod.technoriochallenge.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by binod on 10/5/2017.
 */

public class ApiClient {
    public static final String BASE_URL="http://api.technorio.com/";
    private static Retrofit retrofit=null;

    public  static Retrofit getClient(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
