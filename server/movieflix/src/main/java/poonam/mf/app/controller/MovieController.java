package poonam.mf.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poonam.mf.app.entity.Movie;
import poonam.mf.app.service.MovieService;

@RestController
@RequestMapping(value = "movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController {

	@Autowired
	private MovieService service;

	//Pass Parameter and value: <filter, value>, <sort, value>
	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findByParams(@RequestParam Map<String, String> params) {
		return service.findByParams(params);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Movie findById(@PathVariable("id") String movieId) {
		return service.findById(movieId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie movie) {
		return service.create(movie);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("id") String movieId, @RequestBody Movie movie) {
		return service.update(movieId, movie);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void remove(@PathVariable("id") String movieId) {
		service.remove(movieId);
	}

}
