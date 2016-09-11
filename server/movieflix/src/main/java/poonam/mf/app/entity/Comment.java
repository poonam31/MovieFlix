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
	@NamedQuery(name = "Comment.findByMovieId", query = "SELECT c FROM Comment c JOIN c.movie m where m.id = :pMovieId"),
	@NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c")
})
public class Comment {
	
	@Id
	private String id;
	
	@ManyToOne
	private Movie movie;
	
	@ManyToOne
	private User user;
	
	private String comment;
	
	public Comment() {
		id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
