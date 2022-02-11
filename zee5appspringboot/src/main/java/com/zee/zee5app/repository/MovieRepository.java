package com.zee.zee5app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
	
	// retrieve details based on movieName and language===> findBy word
	// boolean result ===> exists
	
	Optional<Movie> findByMovienameAndLanguage(String moviename, String language);
	
	
	// find a movie details by title/moviename
	// find a movie based on title/moviename and rel Date.
	// find the list of movies based on cast name

}
