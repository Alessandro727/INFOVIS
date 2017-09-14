package it.uniroma3.polyVisualization.repositories;

import org.json.simple.JSONArray;

import it.uniroma3.polyVisualization.polystore.PolystoreFactory;
import it.uniroma3.polystoreMain.Polystore;

public class ActorRepository {

	private static final String QUERY = "SELECT movies.title, movies.vote_average FROM movies, credits, moviecredits, actors "
			+ "WHERE moviecredits.id_movie = movies.id_movie AND credits.id_credit = moviecredits.id_credit "
			+ "AND credits.id_actor = actors.id_actor AND actors.name = '";
	
	public JSONArray filmography(String name) throws Exception {
		Polystore polystore = PolystoreFactory.getOrCreate();
		return polystore.executeQuery(QUERY+name+"'");
	}

}
