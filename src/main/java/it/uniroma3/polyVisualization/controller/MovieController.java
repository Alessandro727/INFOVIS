package it.uniroma3.polyVisualization.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.polyVisualization.services.ActorService;
import it.uniroma3.polyVisualization.services.CastService;
import it.uniroma3.polyVisualization.services.MovieDetailsService;
import it.uniroma3.polyVisualization.services.MovieService;

@RestController("/")
public class MovieController {

	final MovieService movieService;
	final CastService castService;
	final MovieDetailsService movieDetailsService;
	final ActorService actorService;

	@Autowired
	public MovieController(MovieService movieService,CastService castService, MovieDetailsService movieDetailsService, ActorService actorService) {
		this.movieService = movieService;
		this.castService = castService;
		this.movieDetailsService = movieDetailsService;
		this.actorService = actorService;
	}

	@RequestMapping("/graph")
	public Map<String, Object> graph(@RequestParam(value = "title",required = true) String title) {
		return this.movieService.graph(title);
	}

	@RequestMapping("/cast")
	public String cast(@RequestParam(value = "id",required = true) String id) {
		return this.castService.details(id);
	}

	@RequestMapping("/movieDetails")
	public String details(@RequestParam(value = "id",required = true) String id) {
		return this.movieDetailsService.details(id);
	}

	@RequestMapping("/filmography")
	public String actor(@RequestParam(value = "actor",required = true) String name) {
		return this.actorService.filmography(name);
	}

	@RequestMapping("/bubbleChart")
	public String tree(@RequestParam(value = "json",required = true) String json) {
		return json;
	}

}
