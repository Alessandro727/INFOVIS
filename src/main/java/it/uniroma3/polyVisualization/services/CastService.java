package it.uniroma3.polyVisualization.services;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.polyVisualization.repositories.CastRepository;

@Service
public class CastService {

	final CastRepository castRepository = new CastRepository();;

	@Transactional(readOnly = true)
	public String details(String id) {
		try {
			JSONArray array = this.castRepository.details(id);
			return this.parse(array);
		} catch (Exception e) {
			e.printStackTrace();
			return "ERRORE"; //TODO pagina di errore
		}
	}

	@SuppressWarnings("unchecked")
	private String parse(JSONArray array) {

		Iterator<?> i = array.iterator();
		while(i.hasNext()) {
			JSONObject el = (JSONObject) i.next();
			el.remove("id_credit");
			el.remove("id_movie");
			el.remove("profile_path");
			el.remove("id_actor");
			el.remove("id_cast");
			
			String temp;
			/*CHARACTHER*/
			temp = (String) el.remove("character");
			temp = (temp.equals("null")) ? "unknown" : temp;
			el.put("Character", temp);
			/*ACTOR'S NAME*/
			temp = (String) el.remove("name");
			temp = (temp.equals("null")) ? "unknown" : temp;
			el.put("Actor",temp);
			/*ACTOR'S GENDER*/
			temp = (String) el.remove("gender");
			if(temp.equals("1"))
				temp = "F";
			else if(temp.equals("2"))
				temp = "M";
			else //in our case is 0
				temp = "unknown";
			el.put("Gender",temp);
			/*ACTOR'S BIRTHDAY*/
			temp = (String) el.remove("birthday");
			temp = (temp.equals("null")) ? "unknown" : temp;
			el.put("Birthday",temp);
			/*ACTOR'S POPULARITY*/
			temp = (String) el.remove("popularity");
			temp = (temp.equals("null")) ? "unknown" : temp;
			el.put("Popularity",temp);	
		}
		return array.toString();
	}

}
