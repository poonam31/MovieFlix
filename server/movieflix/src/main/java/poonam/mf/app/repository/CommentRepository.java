package poonam.mf.app.repository;

import java.util.List;
import java.util.Map;

import poonam.mf.app.entity.Comment;

public interface CommentRepository {

	Comment findById(String commentId);

	Comment create(Comment comment);

	Comment update(Comment comment);

	void delete(Comment existing);

	List<Comment> findByParams(Map<String, String> params);

}
