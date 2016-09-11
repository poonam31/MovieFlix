package poonam.mf.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poonam.mf.app.entity.Movie;
import poonam.mf.app.entity.Rating;
import poonam.mf.app.entity.User;
import poonam.mf.app.exception.EntityAlreadyExistException;
import poonam.mf.app.exception.EntityNotFoundException;
import poonam.mf.app.repository.MovieRepository;
import poonam.mf.app.repository.RatingRepository;
import poonam.mf.app.repository.UserRepository;

@Service
public class RatingServiceImp implements RatingService {

	@Autowired
	RatingRepository ratingRepository;

	@Autowired
	UserService userService;

	@Autowired
	MovieService movieService;

	@Override
	public Rating findById(String ratingId) {
		Rating existing = ratingRepository.findById(ratingId);
		if (existing == null) {
			throw new EntityNotFoundException("Rating - " + ratingId + " not found. ");
		}
		return existing;
	}

	@Override
	public float findAvgByMovieTitle(Map<String, String> params) {

		return ratingRepository.findAvgByMovieTitle(params);
	}

	@Override
	@Transactional
	public Rating create(Map<String, String> params, Rating rating) {
		List<Rating> existing = ratingRepository.findByUserAndMovieId(params.get("userId"), params.get("movieId"));
		if (existing.size() != 0) {
			throw new EntityAlreadyExistException("Rating exists with this user id - " + params.get("userId")
					+ " and movie Id " + params.get("movieId"));
		}
		Movie movie = movieService.findById(params.get("movieId"));
		User user = userService.findById(params.get("userId"));
		rating.setUser(user);
		rating.setMovie(movie);
		return ratingRepository.create(rating);
	}

	@Override
	@Transactional
	public Rating update(String ratingId, Rating rating) {
		Rating existing = ratingRepository.findById(ratingId);
		if (existing == null) {
			throw new EntityNotFoundException("Rating - " + ratingId + " not found.");
		}
		return ratingRepository.update(rating);
	}

	@Override
	@Transactional
	public void delete(String ratingId) {
		Rating existing = ratingRepository.findById(ratingId);
		if (existing == null) {
			throw new EntityNotFoundException("Rating - " + ratingId + " not found.");
		}
		ratingRepository.delete(existing);

	}

}
