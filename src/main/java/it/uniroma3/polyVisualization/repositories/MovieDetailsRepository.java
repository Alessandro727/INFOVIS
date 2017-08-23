package it.uniroma3.polyVisualization.repositories;

import org.json.simple.JSONArray;

import it.uniroma3.polyVisualization.polystore.PolystoreFactory;
import it.uniroma3.polystoreMain.Polystore;

public class MovieDetailsRepository {

	private static final String QUERY = "SELECT * FROM movies WHERE movies.id_movie = '";

	public JSONArray details(String id) throws Exception {
		Polystore polystore = PolystoreFactory.getOrCreate();
		return polystore.executeQuery(QUERY+id+"'");
	}
	
}
