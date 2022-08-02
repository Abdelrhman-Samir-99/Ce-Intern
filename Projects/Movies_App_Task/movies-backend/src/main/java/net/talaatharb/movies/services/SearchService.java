package net.talaatharb.movies.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import net.talaatharb.movies.dtos.MovieCard;
import net.talaatharb.movies.dtos.MoviePage;
import net.talaatharb.movies.mapper.MovieCardMapper;


@Service
@RequiredArgsConstructor
public class SearchService implements ISearchService {
	
	private final RestTemplate restTemplate;
	private String apiKey = "a97243d7813d31446f6c43284e6854d5";
	private String apiUrl = "https://api.themoviedb.org/3";
	private static final String URL_SEGEMENT_FOR_POPULAR = "/movie/popular";
	
	
	// I need to find a way to map items inside the array to my object.
	@Override
	public MovieCard searchMoviesByName(String title) {
		String urlForMovie = apiUrl + "/search/movie?api_key=" + apiKey + "&query=" + title;
		System.out.println(urlForMovie);
		MoviePage moviePage = restTemplate.getForEntity(urlForMovie, MoviePage.class).getBody();	
		return new MovieCardMapper().fromMoviePage(moviePage);
	}

}
