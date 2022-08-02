package net.talaatharb.movies.mapper;

import net.talaatharb.movies.dtos.MovieCard;
import net.talaatharb.movies.dtos.MoviePage;

public class MovieCardMapper {
	public MovieCard fromMoviePage(MoviePage page) {
		MovieCard movieCard = page.getResults().get(0);
		return movieCard;
	}
}
