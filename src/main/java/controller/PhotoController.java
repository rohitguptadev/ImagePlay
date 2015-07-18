package controller;

import java.util.List;

import model.Pic;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import response.CustomResponse;
import utils.SearchPhoto;

@RequestMapping("/photos")
@RestController
public class PhotoController {
	private static final Logger logger = Logger
			.getLogger(PhotoController.class);

	@RequestMapping(method = RequestMethod.GET)
	public CustomResponse<List<Pic>> getAll(@RequestParam(value="search", defaultValue="house") String searchText ,@RequestParam(value="numOfImages", defaultValue="2") String maxNumOfImages,@RequestParam(value="minConfidence", defaultValue="10.0") String minConfidence ){
		logger.info("searchText "+searchText+" numberOfMaximumImages "+ maxNumOfImages);
		double confidence = 10.0;
		int maxNumImages=10;
		
		try{
			confidence= Double.parseDouble(minConfidence);
			maxNumImages = Integer.parseInt(maxNumOfImages);
		}
		catch(Exception e){
			
		}
		
		CustomResponse<List<Pic>> response = new CustomResponse<List<Pic>>(
				new SearchPhoto().searchPhotoByText(searchText,maxNumImages,confidence), "Success", 0, true);
		
		return response;
		
	}
}
