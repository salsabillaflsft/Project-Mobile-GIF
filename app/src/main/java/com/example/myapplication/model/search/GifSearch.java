package com.example.myapplication.model.search;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GifSearch {

	@SerializedName("next")
	private String next;

	@SerializedName("weburl")
	private String weburl;

	@SerializedName("results")
	private ArrayList<GifSearchResultsItem> results;

	public void setNext(String next){
		this.next = next;
	}

	public String getNext(){
		return next;
	}

	public void setWeburl(String weburl){
		this.weburl = weburl;
	}

	public String getWeburl(){
		return weburl;
	}

	public void setResults(ArrayList<GifSearchResultsItem> results){
		this.results = results;
	}

	public ArrayList<GifSearchResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"GifSearchResponse{" + 
			"next = '" + next + '\'' + 
			",weburl = '" + weburl + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}