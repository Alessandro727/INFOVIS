package it.uniroma3.polyVisualization.services;

import java.util.Iterator;
import java.util.regex.Pattern;

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
			return "ERRORE";
		}
	}

	@SuppressWarnings("unchecked")
	private String parse(JSONArray array) {
		Iterator<?> i = array.iterator();
		while(i.hasNext()) {
			JSONObject el = (JSONObject) i.next();
			el.remove("id_movie");
			
			/*this change is done due to the bubble chart visualization*/
			String temp;
			/*TITLE -> NAME*/
			temp = (String) el.remove("title");
			temp = (temp.equals("null")) ? "unknown" : temp;
			temp = temp.replaceAll(Pattern.quote("&"), "and");
			el.put("name", temp);
			/*VOTE_AVERAGE -> COUNT*/
			temp = (String) el.remove("vote_average");
			temp = (temp.equals("null")) ? "0" : temp;
			el.put("size", temp);
		}
		return array.toString();
	}
	
}
