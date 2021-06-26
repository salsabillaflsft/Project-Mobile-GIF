package com.example.myapplication.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.search.GifSearch;
import com.example.myapplication.model.search.GifSearchResultsItem;
import com.example.myapplication.model.trending.GifTrending;
import com.example.myapplication.model.trending.GifTrendingResultsItem;
import com.example.myapplication.utils.API;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GifViewModel extends ViewModel {
    private API api;
    private MutableLiveData<ArrayList<GifSearchResultsItem>> listSearchGif = new MutableLiveData<>();

    public void setGifSearch(String tag) {
        if (this.api == null) {
            api = new API();
        }

        api.getApiGif().getGifSearch(tag).enqueue(new Callback<GifSearch>() {
            @Override
            public void onResponse(Call<GifSearch> call, Response<GifSearch> response) {
                GifSearch responseSearchGif = response.body();
                if (responseSearchGif != null && responseSearchGif.getResults() != null){
                    ArrayList<GifSearchResultsItem> gifSearchResultsItems = responseSearchGif.getResults();
                    listSearchGif.postValue(gifSearchResultsItems);
                }
            }
            @Override
            public void onFailure(Call<GifSearch> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<GifSearchResultsItem>> getGifSearch(){
        return listSearchGif;
    }

    private MutableLiveData<ArrayList<GifTrendingResultsItem>> listTrendingGif = new MutableLiveData<>();

    public void setGifTrending(){
        if (this.api == null){
            api = new API();
        }
        api.getApiGif().getGifTrending().enqueue(new Callback<GifTrending>() {
            @Override
            public void onResponse(Call<GifTrending> call, Response<GifTrending> response) {
//                berhasil
                GifTrending responseTrendingGif = response.body();
                if (responseTrendingGif != null && responseTrendingGif.getResults() != null){
                    ArrayList<GifTrendingResultsItem> gifTrendingResultsItems = responseTrendingGif.getResults();
                    listTrendingGif.postValue(gifTrendingResultsItems);
                }
            }

            @Override
            public void onFailure(Call<GifTrending> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<GifTrendingResultsItem>> getGifTrending(){
        return listTrendingGif;
    }
}

