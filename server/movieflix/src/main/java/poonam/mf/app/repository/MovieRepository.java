package poonam.mf.app.repository;

import java.util.List;
import java.util.Map;

import poonam.mf.app.entity.Movie;

public interface MovieRepository {

	List<Movie> findByParams(Map<String, String> params);

	Movie findByID(String movieId);

	Movie findByTitle(String movieTitle);

	Movie create(Movie movie);

	Movie update(Movie movie);

	void remove(Movie movie);

	List<Movie> findAll();

}
