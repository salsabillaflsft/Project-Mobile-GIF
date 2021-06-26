package com.example.myapplication.model.search;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GifSearchResultsItem {

	@SerializedName("shares")
	private int shares;

	@SerializedName("created")
	private double created;

	@SerializedName("composite")
	private Object composite;

	@SerializedName("media")
	private List<com.example.myapplication.model.search.MediaItem> media;

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("hasaudio")
	private boolean hasaudio;

	@SerializedName("url")
	private String url;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("itemurl")
	private String itemurl;

	@SerializedName("hascaption")
	private boolean hascaption;

	public void setShares(int shares){
		this.shares = shares;
	}

	public int getShares(){
		return shares;
	}

	public void setCreated(double created){
		this.created = created;
	}

	public double getCreated(){
		return created;
	}

	public void setComposite(Object composite){
		this.composite = composite;
	}

	public Object getComposite(){
		return composite;
	}

	public void setMedia(List<com.example.myapplication.model.search.MediaItem> media){
		this.media = media;
	}

	public List<com.example.myapplication.model.search.MediaItem> getMedia(){
		return media;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setHasaudio(boolean hasaudio){
		this.hasaudio = hasaudio;
	}

	public boolean isHasaudio(){
		return hasaudio;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setTags(List<Object> tags){
		this.tags = tags;
	}

	public List<Object> getTags(){
		return tags;
	}

	public void setItemurl(String itemurl){
		this.itemurl = itemurl;
	}

	public String getItemurl(){
		return itemurl;
	}

	public void setHascaption(boolean hascaption){
		this.hascaption = hascaption;
	}

	public boolean isHascaption(){
		return hascaption;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"shares = '" + shares + '\'' + 
			",created = '" + created + '\'' + 
			",composite = '" + composite + '\'' + 
			",media = '" + media + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",hasaudio = '" + hasaudio + '\'' + 
			",url = '" + url + '\'' + 
			",tags = '" + tags + '\'' + 
			",itemurl = '" + itemurl + '\'' + 
			",hascaption = '" + hascaption + '\'' + 
			"}";
		}
}