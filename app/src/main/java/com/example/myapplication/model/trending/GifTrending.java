package com.example.myapplication.model.trending;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GifTrending {
    @SerializedName("next")
    private String next;

    @SerializedName("results")
    private ArrayList<GifTrendingResultsItem> results;

    public void setNext(String next){
        this.next = next;
    }

    public String getNext(){
        return next;
    }

    public void setResults(ArrayList<GifTrendingResultsItem> results){
        this.results = results;
    }

    public ArrayList<GifTrendingResultsItem> getResults(){
        return results;
    }

    @Override
    public String toString(){
        return
                "GifTrendingResponse{" +
                        "next = '" + next + '\'' +
                        ",results = '" + results + '\'' +
                        "}";
    }
}
