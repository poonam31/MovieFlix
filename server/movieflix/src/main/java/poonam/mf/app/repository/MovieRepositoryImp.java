package poonam.mf.app.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import poonam.mf.app.entity.Movie;

@Repository
public class MovieRepositoryImp implements MovieRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findByID(String movieId) {
		return em.find(Movie.class, movieId);
	}

	@Override
	public List<Movie> findByParams(Map<String, String> params) {
		TypedQuery<Movie> query = null;

		if (params.get("filter") == "type") {
			if (params.get("sort") == "year")
				query = em.createNamedQuery("Movie.findByTypeSortByYear", Movie.class);
			else if (params.get("sort") == "rating")
				query = em.createNamedQuery("Movie.findByTypeSortByRating", Movie.class);
			else if (params.get("sort") == "votes")
				query = em.createNamedQuery("Movie.findByTypeSortByVotes", Movie.class);
			else
				query = em.createNamedQuery("Movie.findByType", Movie.class);
			query.setParameter("pType", params.get("type"));
		} else if (params.get("filter") == "genre") {
			if (params.get("sort") == "year")
				query = em.createNamedQuery("Movie.findByGenreSortByYear", Movie.class);
			else if (params.get("sort") == "rating")
				query = em.createNamedQuery("Movie.findByGenreSortByRating", Movie.class);
			else if (params.get("sort") == "votes")
				query = em.createNamedQuery("Movie.findByGenreSortByVotes", Movie.class);
			else
				query = em.createNamedQuery("Movie.findByGenre", Movie.class);
			query.setParameter("pGenre", params.get("genre"));
		} else if (params.get("filter") == "year") {
			if (params.get("sort") == "year")
				query = em.createNamedQuery("Movie.findByYearSortByYear", Movie.class);
			else if (params.get("sort") == "rating")
				query = em.createNamedQuery("Movie.findByYearSortByRating", Movie.class);
			else if (params.get("sort") == "votes")
				query = em.createNamedQuery("Movie.findByYearSortByVotes", Movie.class);
			else
				query = em.createNamedQuery("Movie.findByYear", Movie.class);
			query.setParameter("pYear", Integer.parseInt(params.get("year")));

		} else {
			if (params.get("sort") == "year")
				query = em.createNamedQuery("Movie.findAllSortByYear", Movie.class);
			else if (params.get("sort") == "rating")
				query = em.createNamedQuery("Movie.findAllSortByRating", Movie.class);
			else if (params.get("sort") == "votes")
				query = em.createNamedQuery("Movie.findAllSortByVotes", Movie.class);
			else
				query = em.createNamedQuery("Movie.findAll", Movie.class);
		}

		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public Movie findByTitle(String movieTitle) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pMovieTitle", movieTitle);
		List<Movie> movies = query.getResultList();
		if (movies != null && movies.size() == 1) {
			return movies.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
	}

	@Override
	public void remove(Movie existing) {
		em.remove(existing);

	}

}
