package it.uniroma3.polyVisualization.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.polyVisualization.services.MovieService;

/**
 * @author Mark Angrish
 */
@RestController("/")
public class MovieController {

	final MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@RequestMapping("/graph")
	public Map<String, Object> graph(@RequestParam(value = "title",required = true) String title) {
		return movieService.graph(title);
	}
}