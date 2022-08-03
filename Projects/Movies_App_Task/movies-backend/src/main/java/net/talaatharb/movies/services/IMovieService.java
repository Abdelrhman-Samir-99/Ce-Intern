package net.talaatharb.movies.services;

import org.springframework.stereotype.Service;

import net.talaatharb.movies.dtos.MoviePage;
import net.talaatharb.movies.model.MovieCardCacheItem;

@Service
public interface IMovieService {
	public MoviePage getPopularMoviesPage(int page);
	public MovieCardCacheItem getMovieDetailsById(int id);
}
