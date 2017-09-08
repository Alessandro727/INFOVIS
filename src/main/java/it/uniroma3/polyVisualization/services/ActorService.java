package it.uniroma3.polyVisualization.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.polyVisualization.repositories.ActorRepository;

@Service
public class ActorService {

	final ActorRepository actorRepository = new ActorRepository();
	
	@Transactional(readOnly = true)
	public String filmography(String name) {
		try {
			return this.actorRepository.filmography(name).toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "ERRORE"; //TODO pagina di errore
		}
	}
	
}
