package poonam.mf.app.entity;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m ORDER BY m.year DESC"),
		@NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title=:pTitle"),
		@NamedQuery(name = "Movie.findByTypeSortByYear", query = "SELECT m FROM Movie m WHERE m.type=:pType ORDER BY m.year DESC"),
		@NamedQuery(name = "Movie.findByTypeSortByRating", query = "SELECT m FROM Movie m WHERE m.type=:pType ORDER BY m.imdbRating DESC"),
		@NamedQuery(name = "Movie.findByTypeSortByVotes", query = "SELECT m FROM Movie m WHERE m.type=:pType ORDER BY m.imdbVotes DESC"),
		@NamedQuery(name = "Movie.findByType", query = "SELECT m FROM Movie m WHERE m.type=:pType"),
		@NamedQuery(name = "Movie.findByYearSortByYear", query = "SELECT m FROM Movie m WHERE m.year=:pYear ORDER BY m.year DESC"),
		@NamedQuery(name = "Movie.findByYearSortByRating", query = "SELECT m FROM Movie m WHERE m.year=:pYear ORDER BY m.imdbRating DESC"),
		@NamedQuery(name = "Movie.findByYearSortByVotes", query = "SELECT m FROM Movie m WHERE m.year=:pYear ORDER BY m.imdbVotes DESC"),
		@NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m WHERE m.year=:pYear"),
		@NamedQuery(name = "Movie.findByGenreSortByYear", query = "SELECT m from Movie m JOIN m.genres g WHERE g.genreType = :pGenre ORDER BY m.year DESC"),
		@NamedQuery(name = "Movie.findByGenreSortByRating", query = "SELECT m from Movie m JOIN m.genres g WHERE g.genreType = :pGenre ORDER BY m.imdbRating DESC"),
		@NamedQuery(name = "Movie.findByGenreSortByVotes", query = "SELECT m from Movie m JOIN m.genres g WHERE g.genreType = :pGenre ORDER BY m.imdbVotes DESC"),
		@NamedQuery(name = "Movie.findByGenre", query = "SELECT m from Movie m JOIN m.genres g WHERE g.genreType = :pGenre"),
		@NamedQuery(name = "Movie.findAllSortByYear", query = "SELECT m FROM Movie m ORDER BY m.year DESC"),
		@NamedQuery(name = "Movie.findAllSortByRating", query = "SELECT m FROM Movie m ORDER BY m.imdbRating DESC"),
		@NamedQuery(name = "Movie.findAllSortByVotes", query = "SELECT m FROM Movie m ORDER BY m.imdbVotes DESC") })
public class Movie {

	@Id
	private String id;

	@Column(unique = true)
	private String title;

	private int year;
	private String rated;
	private Date released;
	private String runtime;

	private float imdbRating;

	@ManyToMany
	private Set<Genre> genres;

	private String director;

	@ManyToMany
	private Set<Writer> writers;

	@ManyToMany
	private Set<Cast> actors;

	private String plot;

	@ManyToMany
	private Set<Language> languages;

	@ManyToMany
	private Set<Country> countries;

	private String awards;
	private String poster;
	private int metascore;
	private int imdbVotes;
	private String imdbId;
	private String type;

	public Movie() {
		id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public Date getReleased() {
		return released;
	}

	public void setReleased(Date released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Set<Writer> getWriters() {
		return writers;
	}

	public void setWriters(Set<Writer> writers) {
		this.writers = writers;
	}

	public Set<Cast> getActors() {
		return actors;
	}

	public void setActors(Set<Cast> actors) {
		this.actors = actors;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public Set<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}

	public Set<Country> getCountries() {
		return countries;
	}

	public void setCountries(Set<Country> countries) {
		this.countries = countries;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getMetascore() {
		return metascore;
	}

	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}

	public int getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}

}
