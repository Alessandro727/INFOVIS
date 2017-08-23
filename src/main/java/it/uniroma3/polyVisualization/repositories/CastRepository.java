package it.uniroma3.polyVisualization.repositories;

import org.json.simple.JSONArray;

import it.uniroma3.polystoreMain.Polystore;

public class CastRepository {

	private static final String QUERY = "SELECT * FROM moviecredits, credits, actors WHERE credits.id_actor = actors.id_actor AND moviecredits.id_credit = credits.id_credit AND moviecredits.id_movie = '";

	public JSONArray details(String id) throws Exception {
		return new Polystore().executeQuery(QUERY+id+"'");
	}

}
