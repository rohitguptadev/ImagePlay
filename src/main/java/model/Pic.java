package model;

import java.util.ArrayList;

public class Pic {

	String url;
	ArrayList<String> tags;
	public Pic(String url, ArrayList<String> tags) {
		super();
		this.url = url;
		this.tags = tags;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ArrayList<String> getTags() {
		return tags;
	}
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	
	

}
