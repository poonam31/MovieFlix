package poonam.mf.app.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import poonam.mf.app.entity.Comment;

@Repository
public class CommentRepositoryImp implements CommentRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Comment> findByParams(Map<String, String> params) {
		TypedQuery<Comment> query;
		if (params.get("movieId") != null) {
			query = em.createNamedQuery("Comment.findByMovieId", Comment.class);
			query.setParameter("pMovieId", params.get("movieId"));
		} else
			query = em.createNamedQuery("Comment.findAll", Comment.class);
		return query.getResultList();
	}

	@Override
	public Comment findById(String commentId) {
		return em.find(Comment.class, commentId);
	}

	@Override
	public Comment create(Comment comment) {
		em.persist(comment);
		return comment;
	}

	@Override
	public Comment update(Comment comment) {
		return em.merge(comment);
	}

	@Override
	public void delete(Comment existing) {
		em.remove(existing);

	}

}
