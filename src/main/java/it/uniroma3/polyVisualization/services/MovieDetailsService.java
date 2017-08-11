package it.uniroma3.polyVisualization.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.polyVisualization.repositories.MovieDetailsRepository;

@Service
public class MovieDetailsService {
	
	final MovieDetailsRepository movieDetailsRepository = new MovieDetailsRepository();;

	@Transactional(readOnly = true)
	public String details(String id) {
		return this.movieDetailsRepository.details(id);
	}

}
