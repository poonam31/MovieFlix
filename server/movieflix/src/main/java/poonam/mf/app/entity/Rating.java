package poonam.mf.app.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Rating.findByUserAndMovieId", query = "SELECT r FROM Rating r WHERE r.user.id = :pUserId AND r.movie.id = :pMovieId"),
	@NamedQuery(name = "Rating.findAvgByMovieTitle", query = "SELECT avg(r.rating) FROM Rating r WHERE r.movie.title = :pMovieTitle")
})
public class Rating {
	
	@Id
	private String id;
	
	private float rating;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Movie movie;
	
	public Rating() {
		id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
	
}
