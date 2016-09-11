package poonam.mf.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poonam.mf.app.entity.Movie;
import poonam.mf.app.exception.EntityAlreadyExistException;
import poonam.mf.app.exception.EntityNotFoundException;
import poonam.mf.app.repository.MovieRepository;

@Service
public class MovieServiceImp implements MovieService {

	@Autowired
	private MovieRepository repository;

	@Override
	public List<Movie> findByParams(Map<String, String> params) {
		return repository.findByParams(params);
	}

	@Override
	public Movie findById(String movieId) {
		Movie mov = repository.findByID(movieId);
		if (mov == null) {
			throw new EntityNotFoundException("Movie not found.");
		}
		return mov;
	}

	@Override
	@Transactional
	public Movie create(Movie movie) {
		Movie existing = repository.findByTitle(movie.getTitle());
		if (existing != null) {
			throw new EntityAlreadyExistException("Movie already exists with this title");
		}
		return repository.create(movie);
	}

	@Override
	@Transactional
	public Movie update(String movieId, Movie movie) {
		Movie existing = repository.findByID(movieId);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found.");
		}
		return repository.update(movie);
	}

	@Override
	@Transactional
	public void remove(String movieId) {
		Movie existing = repository.findByID(movieId);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		repository.remove(existing);
	}

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

}
