package controller;

import java.util.List;

import model.Pic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import response.CustomResponse;
import utils.SearchPhoto;

@RequestMapping("/photos")
@RestController
public class PhotoController {
	
	@RequestMapping(method = RequestMethod.GET)
	public CustomResponse<List<Pic>> getAll(@RequestParam(value="search", defaultValue="house") String searchText){
		CustomResponse<List<Pic>> response = new CustomResponse<List<Pic>>(
				new SearchPhoto().searchPhotoByText(searchText), "Success", 0, true);
		
		return response;
		
	}

}
