package it.uniroma3.polyVisualization.services;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.polyVisualization.repositories.MovieDetailsRepository;

@Service
public class MovieDetailsService {

	final MovieDetailsRepository movieDetailsRepository = new MovieDetailsRepository();

	@Transactional(readOnly = true)
	public String details(String id) {
		try {
			JSONArray details = this.movieDetailsRepository.details(id);
			return this.parse(details);
		} catch (Exception e) {
			e.printStackTrace();
			return "ERRORE";
		}
	}

	private String parse(JSONArray details) {
		Iterator<?> i = details.iterator();
		while(i.hasNext()) {
			JSONObject el = (JSONObject) i.next();
			el.remove("video");
			el.remove("backdrop_path");
			el.remove("id_movie");
			el.remove("poster_path");
			el.remove("belongs_to_collection");
			el.remove("tagline");
			el.remove("_id");

			this.removeInnerField(el, "genres", "id");
			this.removeInnerField(el, "production_countries", "iso_3166_1");
			this.removeInnerField(el, "spoken_languages", "iso_639_1");
			this.removeInnerField(el, "production_companies", "id");
		}
		return details.toString();
	}

	@SuppressWarnings("unchecked")
	private void removeInnerField(JSONObject json, String getField, String removeField) {
		JSONParser parser = new JSONParser();
		JSONArray element = null;
		try {
			element = (JSONArray) parser.parse((String) json.get(getField));
			Iterator<?>  iterator = element.iterator();
			while(iterator.hasNext())  {
				JSONObject obj = (JSONObject) iterator.next();
				obj.remove(removeField);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		json.replace(getField,element);
	}
}
