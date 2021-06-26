package com.example.myapplication.utils;

import com.example.myapplication.model.search.GifSearch;
import com.example.myapplication.model.trending.GifTrending;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GifRepo {
    //@GET("categories?key=IUQWVTZ0C6Z9")
    //Call<GifCategories> getGifCategories();
    //@GET("gifs?&key=IUQWVTZ0C6Z9")
    //Call<GifSearchId> getGifSearchId(@Query("ids") String id);
    @GET("search?key=IUQWVTZ0C6Z9&safesearch=strict")
    Call<GifSearch> getGifSearch(@Query("tag") String tag);
    @GET("trending?key=IUQWVTZ0C6Z9")
    Call<GifTrending> getGifTrending();
}

