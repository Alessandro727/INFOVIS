package it.uniroma3.polyVisualization.services;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.polyVisualization.repositories.ActorRepository;

@Service
public class ActorService {

	final ActorRepository actorRepository = new ActorRepository();
	
	@Transactional(readOnly = true)
	public String filmography(String name) {
		try {
			JSONArray array = this.actorRepository.filmography(name);
			return this.parse(array);
		} catch (Exception e) {
			e.printStackTrace();
			return "ERRORE"; //TODO pagina di errore
		}
	}

	private String parse(JSONArray array) {
		Iterator<?> i = array.iterator();
		while(i.hasNext()) {
			JSONObject el = (JSONObject) i.next();
			el.remove("id_movie");
		}
		return array.toString();
	}
	
}
