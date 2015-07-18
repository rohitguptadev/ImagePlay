package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.Pic;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.noggit.JSONParser;
import org.springframework.boot.json.JsonJsonParser;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.SearchParameters;
import com.flickr4java.flickr.util.Base64;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import constants.FlickerConstants;

public class SearchPhoto {
	private static final Logger logger = Logger.getLogger(SearchPhoto.class);

	private String nsid;

	private String username;

	// private final String sharedSecret;

	private final Flickr flickr;

	public SearchPhoto() {

		flickr = new Flickr(FlickerConstants.FLICKER_KEY,
				FlickerConstants.FLICKER_SECRET, new REST());
	}

	public ArrayList<Pic> searchPhotoByText(String text, int numOfImages,
			double confidence) {
		SearchParameters searchParameters = new SearchParameters();
		searchParameters.setText(text);
		ArrayList<Pic> result = new ArrayList<>();
		try {
			PhotoList<Photo> list = flickr.getPhotosInterface().search(
					searchParameters, 0, 0);
			int i = 0;
			for (Photo photo : list) {

				if (i < numOfImages) {
					result.add(new Pic(photo.getLarge1600Url(),
							getTagsImagga(photo.getLarge1600Url(),confidence)));
				}

				i++;
			}
		} catch (FlickrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	private ArrayList<String> getTagsImagga(String url, double confidence) {
		ArrayList<String> result = new ArrayList<>();
		try {

			HttpResponse<String> response = Unirest
					.get("http://api.imagga.com/v1/tagging?url=" + url)
					.header("accept", "application/json")
					.header("authorization",
							"Basic YWNjX2NhOTgxNmFkODRjYjgwYzpiZjk5OTk5YmQ4MmQ4YTgzNmZmOTI4ZGQ3YmEyODRkZA==")
					.asString();
			// result.add(response.getRawBody());
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getRawBody()));
			StringBuilder content = new StringBuilder();
			String line;
			try {
				while (null != (line = rd.readLine())) {
					content.append(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			result = getTagsFromJson(content.toString(), confidence);
			// result.add(content.toString());

		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

	private ArrayList<String> getTagsFromJson(String jsonString,
			double confidence) {
		ArrayList<String> tagsPic = new ArrayList<>();
		try {

			JSONObject jsonObject = new JSONObject(jsonString);
			JSONArray result = (JSONArray) jsonObject.get("results");
			JSONObject mainObj = (JSONObject) result.get(0);
			JSONArray tags = (JSONArray) mainObj.get("tags");

			for (int i = 0; i < tags.length(); i++) {
				double conf = 100;
				try{
				conf = Double.parseDouble(((JSONObject) tags.get(i))
						.getString("confidence"));
				}
				catch (Exception e){
					
				}
				if (conf > confidence)
					tagsPic.add(((JSONObject) tags.get(i)).getString("tag"));

			}

		} catch (Exception e) {

		}

		return tagsPic;

	}

}
