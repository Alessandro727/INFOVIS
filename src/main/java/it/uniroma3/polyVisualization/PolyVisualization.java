package it.uniroma3.polyVisualization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("it.uniroma3.polyVisualization.model")
public class PolyVisualization {

	public static void main(String[] args) {
		SpringApplication.run(PolyVisualization.class, args);
	}
}
