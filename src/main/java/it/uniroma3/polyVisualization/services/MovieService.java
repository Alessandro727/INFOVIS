package it.uniroma3.polyVisualization.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.polyVisualization.model.Movie;
import it.uniroma3.polyVisualization.model.Role;
import it.uniroma3.polyVisualization.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired MovieRepository movieRepository;

	private Map<String, Object> toD3Format(Collection<Movie> movies) {
		List<Map<String, Object>> nodes = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> rels = new ArrayList<Map<String, Object>>();
		int i = 0;
		Iterator<Movie> result = movies.iterator();
		while (result.hasNext()) {
			Movie movie = result.next();
			nodes.add(map("title", movie.getTitle(), "label", "movie"));
			int target = i;
			i++;
			for (Role role : movie.getRoles()) {
				Map<String, Object> otherMovie = map("title", role.getMovie2().getTitle(), "label", "movie");
				int source = nodes.indexOf(otherMovie);
				if (source == -1) {
					nodes.add(otherMovie);
					source = i++;
				}
				rels.add(map("source", source, "target", target));
			}
		}
		return map("nodes", nodes, "links", rels);
	}

	private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		result.put(key1, value1);
		result.put(key2, value2);
		return result;
	}

	@Transactional(readOnly = true)
	public Map<String, Object>  graph(String title) {
		Collection<Movie> result = movieRepository.graph(title);
		return toD3Format(result);
	}
}
