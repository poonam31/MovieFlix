package poonam.mf.app.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import poonam.mf.app.entity.Rating;

@Repository
public class RatingRepositoryImp implements RatingRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Rating findById(String ratingId) {
		return em.find(Rating.class, ratingId);
	}

	@Override
	public float findAvgByMovieTitle(Map<String, String> params) {
		TypedQuery<Float> query;
		float ratingAvg;
		if (params.get("movieTitle") != null) {
			query = em.createNamedQuery("Rating.findAvgByMovieTitle", Float.class);
			query.setParameter("pMovieTitle", params.get("movieTitle"));
			ratingAvg = query.getSingleResult();
		} else
			ratingAvg = 0;

		return ratingAvg;
	}

	@Override
	public List<Rating> findByUserAndMovieId(String userId, String movieId) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findByUserAndMovieId", Rating.class);
		query.setParameter("pUserId", userId);
		query.setParameter("pMovieId", movieId);
		return query.getResultList();
	}

	@Override
	public Rating create(Rating rating) {
		em.persist(rating);
		return rating;
	}

	@Override
	public Rating update(Rating rating) {
		return em.merge(rating);
	}

	@Override
	public void delete(Rating existing) {
		em.remove(existing);
	}

}
