package poonam.mf.app.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Genre {
	
	@Id
	private String id;
	
	private String genreType;
	

	public Genre() {
		id = UUID.randomUUID().toString();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getGenreType() {
		return genreType;
	}


	public void setGenreType(String genreType) {
		this.genreType = genreType;
	}
	
	

}
