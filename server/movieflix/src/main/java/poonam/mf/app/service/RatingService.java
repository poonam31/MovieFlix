package poonam.mf.app.service;

import java.util.Map;

import poonam.mf.app.entity.Rating;

public interface RatingService {

	Rating findById(String ratingId);

	Rating create(Map<String, String> params, Rating rating);

	Rating update(String id, Rating rating);

	void delete(String id);

	float findAvgByMovieTitle(Map<String, String> params);

}
