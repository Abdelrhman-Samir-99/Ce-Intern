package net.talaatharb.movies.services;


import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import net.talaatharb.movies.dtos.MoviePage;
import net.talaatharb.movies.model.MovieCardCache;

@Service
public interface IMovieService {
	public MoviePage getPopularMoviesPage(int page);
	public MovieCardCache getMovieDetailsById(int id);
}
