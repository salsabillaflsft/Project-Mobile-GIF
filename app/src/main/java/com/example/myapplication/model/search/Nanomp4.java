package com.example.myapplication.model.search;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Nanomp4{

	@SerializedName("duration")
	private double duration;

	@SerializedName("preview")
	private String preview;

	@SerializedName("dims")
	private List<Integer> dims;

	@SerializedName("size")
	private int size;

	@SerializedName("url")
	private String url;

	public void setDuration(double duration){
		this.duration = duration;
	}

	public double getDuration(){
		return duration;
	}

	public void setPreview(String preview){
		this.preview = preview;
	}

	public String getPreview(){
		return preview;
	}

	public void setDims(List<Integer> dims){
		this.dims = dims;
	}

	public List<Integer> getDims(){
		return dims;
	}

	public void setSize(int size){
		this.size = size;
	}

	public int getSize(){
		return size;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Nanomp4{" + 
			"duration = '" + duration + '\'' + 
			",preview = '" + preview + '\'' + 
			",dims = '" + dims + '\'' + 
			",size = '" + size + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}