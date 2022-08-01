package net.talaatharb.movies.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import net.talaatharb.movies.dtos.MoviePage;

@Service
@RequiredArgsConstructor
public class MovieDBService {

	private final RestTemplate restTemplate;

	private String apiKey = "a97243d7813d31446f6c43284e6854d5";

	private String apiUrl = "https://api.themoviedb.org/3";

	private static final String URL_SEGEMENT_FOR_POPULAR = "/movie/popular";

	public MoviePage getPopularMovies(Integer page) {
		String urlForPopularMovies = apiUrl + URL_SEGEMENT_FOR_POPULAR + "?api_key=" + apiKey + "&page="
				+ page.intValue();
		System.out.println(urlForPopularMovies);
		return restTemplate.getForEntity(urlForPopularMovies, MoviePage.class).getBody();
	}
}
