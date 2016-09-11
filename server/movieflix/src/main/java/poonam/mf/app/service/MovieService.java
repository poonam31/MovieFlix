package poonam.mf.app.service;

import java.util.List;
import java.util.Map;

import poonam.mf.app.entity.Movie;

public interface MovieService {

	public List<Movie> findByParams(Map<String, String> params);

	public Movie findById(String movieId);

	public Movie create(Movie movie);

	public Movie update(String movieId, Movie movie);

	public void remove(String movieId);

	public List<Movie> findAll();

}
