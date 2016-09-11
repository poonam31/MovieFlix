package poonam.mf.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poonam.mf.app.entity.Rating;
import poonam.mf.app.service.RatingService;

@RestController
@RequestMapping(value = "ratings", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RatingController {
	
	@Autowired
	private RatingService service;
	
	//Pass Parameter and value: <movieTitle, value>
	@RequestMapping(method = RequestMethod.GET)
	public float findAvgByMovieTitle(@RequestParam Map<String, String> params) {
		return service.findAvgByMovieTitle(params);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Rating findById(@PathVariable("id") String ratingId) {
		return service.findById(ratingId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating create(@RequestParam Map<String, String> params, @RequestBody Rating rating) {
		return service.create(params,rating);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating update(@PathVariable("id") String id, @RequestBody Rating rating) {
		return service.update(id, rating);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
	

}
