package com.zee.zee5app.service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.repository.MovieRepository;


public class MovieService {
	private MovieRepository repository = MovieRepository.getInstance();
	private static MovieService service = null;		
	
	public static MovieService getInstance() {
		if(service == null)
			service = new MovieService();
		return service;
	}
	
	public String addMovie(Movie movie) {
		return this.repository.addMovie(movie);
	}
	
	public Movie getMovieById(String id) {
		return this.repository.getMovieById(id);
	}
	
	public Movie[] getAllMovies() {
		return repository.getAllMovie();
	}

}
