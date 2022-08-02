package net.talaatharb.movies.services;

import org.springframework.stereotype.Service;

import net.talaatharb.movies.dtos.MovieCard;

@Service
public interface ISearchService {
	public MovieCard searchMoviesByName(String title);
}
