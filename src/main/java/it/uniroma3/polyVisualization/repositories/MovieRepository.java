package it.uniroma3.polyVisualization.repositories;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import it.uniroma3.polyVisualization.model.Movie;

@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {

	Movie findByTitle(@Param("title") String title);

	Collection<Movie> findByTitleLike(@Param("title") String title);

	@Query("MATCH (m:Movie)<-[r:RELATED]-(a:Movie) WHERE m.title = {title} RETURN m,r,a LIMIT 100")
	Collection<Movie> graph(@Param("title") String title);
}

