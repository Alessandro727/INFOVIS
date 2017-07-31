package movies.spring.data.neo4j.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author Mark Angrish
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Movie {

	@GraphId
	private Long id;

	private String title;

	private String id_movie;

	
	@Relationship(type = "RELATED", direction = Relationship.OUTGOING)
	private List<Role> rolesIn = new ArrayList<Role>();

	public Movie() {
	}

	public Movie(String title, String id_movie) {

		this.title = title;
		this.setId_movie(id_movie);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	
	public Collection<Role> getRoles() {
		return this.rolesIn;
	}


	
	public void addRole(Role role) {
		this.rolesIn.add(role);
	}

	public String getId_movie() {
		return id_movie;
	}

	public void setId_movie(String id_movie) {
		this.id_movie = id_movie;
	}
}
