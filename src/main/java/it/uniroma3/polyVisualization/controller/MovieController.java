package it.uniroma3.polyVisualization.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.polyVisualization.services.MovieDetailsService;
import it.uniroma3.polyVisualization.services.MovieService;

@RestController("/")
public class MovieController {

	final MovieService movieService;
	final MovieDetailsService movieDetailsService;

	@Autowired
	public MovieController(MovieService movieService,MovieDetailsService movieDetailsService) {
		this.movieService = movieService;
		this.movieDetailsService = movieDetailsService;
	}

	@RequestMapping("/graph")
	public Map<String, Object> graph(@RequestParam(value = "title",required = true) String title) {
		return movieService.graph(title);
	}
	
	@RequestMapping("/movieDetails")
	public String details(@RequestParam(value = "id",required = true) String id) {
		return this.movieDetailsService.details(id);
	}
	
	@RequestMapping("/tree")
	public String tree(@RequestParam(value = "json",required = true) String json) {
		return json;
	}
	
}
