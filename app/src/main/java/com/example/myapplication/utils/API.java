package com.example.myapplication.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    private Retrofit retrofit;

    public GifRepo getApiGif(){
        String BASE_URL = "https://g.tenor.com/v1/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(GifRepo.class);
    }

}
