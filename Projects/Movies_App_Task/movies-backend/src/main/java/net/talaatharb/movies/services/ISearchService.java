package net.talaatharb.movies.services;

import net.talaatharb.movies.dtos.MoviePage;
import org.springframework.stereotype.Service;

import net.talaatharb.movies.dtos.MovieCard;

@Service
public interface ISearchService {
	public MoviePage searchMoviesByName(String title);
}
