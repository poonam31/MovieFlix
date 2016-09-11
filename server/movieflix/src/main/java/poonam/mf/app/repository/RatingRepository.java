package poonam.mf.app.repository;

import java.util.List;
import java.util.Map;

import poonam.mf.app.entity.Movie;
import poonam.mf.app.entity.Rating;

public interface RatingRepository {

	Rating findById(String ratingId);

	Rating create(Rating rating);

	Rating update(Rating rating);

	void delete(Rating existing);

	List<Rating> findByUserAndMovieId(String string, String string2);

	float findAvgByMovieTitle(Map<String, String> params);

}
