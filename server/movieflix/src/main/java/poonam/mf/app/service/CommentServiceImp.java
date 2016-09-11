package poonam.mf.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poonam.mf.app.entity.Comment;
import poonam.mf.app.entity.Movie;
import poonam.mf.app.entity.User;
import poonam.mf.app.exception.EntityNotFoundException;
import poonam.mf.app.repository.CommentRepository;
import poonam.mf.app.repository.MovieRepository;
import poonam.mf.app.repository.UserRepository;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentRepository repository;

	@Autowired
	MovieService movieService;

	@Autowired
	UserService userService;

	@Override
	public List<Comment> findByParams(Map<String, String> params) {
		return repository.findByParams(params);
	}

	@Override
	public Comment findById(String commentId) {
		Comment existing = repository.findById(commentId);
		if (existing == null) {
			throw new EntityNotFoundException("Comment - " + commentId + " not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public Comment create(Map<String, String> params, Comment comment) {

		Movie movie = movieService.findById(params.get("movieId"));
		User user = userService.findById(params.get("userId"));
		comment.setUser(user);
		comment.setMovie(movie);
		return repository.create(comment);
	}

	@Override
	@Transactional
	public Comment update(String commentId, Comment comment) {
		Comment existing = repository.findById(commentId);
		if (existing == null) {
			throw new EntityNotFoundException("Comment -" + commentId + " not found");
		}
		return repository.update(comment);
	}

	@Override
	@Transactional
	public void delete(String commentId) {
		Comment existing = repository.findById(commentId);
		if (existing == null) {
			throw new EntityNotFoundException("Comment - " + commentId + " not found");
		}
		repository.delete(existing);

	}

}
