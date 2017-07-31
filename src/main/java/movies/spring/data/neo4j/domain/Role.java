package movies.spring.data.neo4j.domain;


import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author Mark Angrish
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@RelationshipEntity(type = "RELATED")
public class Role {

	@GraphId
	private Long id;

	private Collection<String> roles = new ArrayList<String>();

	@StartNode
	private Movie movie1;

	@EndNode
	private Movie movie2;

	public Role() {
	}

	public Role(Movie movie1, Movie movie2) {
		this.movie1 = movie1;
		this.movie2 = movie2;
	}

	public Long getId() {
		return id;
	}

	public Collection<String> getRoles() {
		return roles;
	}

	public Movie getMovie2() {
		return this.movie2;
	}

	public Movie getMovie1() {
		return this.movie1;
	}

	public void addRoleName(String name) {
		this.roles.add(name);
	}
}
