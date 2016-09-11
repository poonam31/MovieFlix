package poonam.mf.app.service;

import java.util.List;
import java.util.Map;

import poonam.mf.app.entity.Comment;

public interface CommentService {

	Comment findById(String id);

	Comment create(Map<String, String> params, Comment comment);

	Comment update(String id, Comment comment);

	void delete(String id);

	List<Comment> findByParams(Map<String, String> params);

}
