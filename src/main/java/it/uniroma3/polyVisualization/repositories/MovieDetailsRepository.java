package it.uniroma3.polyVisualization.repositories;

import org.json.simple.JSONArray;

import it.uniroma3.polystoreMain.Polystore;

public class MovieDetailsRepository {

	private static final String QUERY = "SELECT * FROM moviecredits, credits WHERE moviecredits.id_credit = credits.id_credit AND moviecredits.id_movie = '";

	public String details(String id) {
		try {
			JSONArray array = new Polystore().executeQuery(QUERY+id+"'");
			return array.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ERRORE"; //TODO inserire pagina errore
	}

}
