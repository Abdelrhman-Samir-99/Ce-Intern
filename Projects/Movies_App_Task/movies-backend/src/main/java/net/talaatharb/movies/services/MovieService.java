package net.talaatharb.movies.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import net.talaatharb.movies.caches.IMovieCardCache;
import net.talaatharb.movies.dtos.MoviePage;
import net.talaatharb.movies.model.MovieCardCacheItem;
import net.talaatharb.movies.reposotiry.MovieCardCacheRepository;

@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService {

	private final RestTemplate restTemplate;
	private String apiKey = "a97243d7813d31446f6c43284e6854d5";
	private String apiUrl = "https://api.themoviedb.org/3";
	private static final String URL_SEGEMENT_FOR_POPULAR = "/movie/popular";
	
	@Autowired
	MovieCardCacheRepository movieCardCacheReposoitry;
	@Autowired
	IMovieCardCache movieCardCache;
	
	@Override
	public MoviePage getPopularMoviesPage(int page) {
		String urlForPopularMovies = apiUrl + URL_SEGEMENT_FOR_POPULAR + "?api_key=" + apiKey + "&page="
				+ page;
		System.out.println(urlForPopularMovies);
		System.out.println(restTemplate.getForEntity(urlForPopularMovies, MoviePage.class));
		// System.out.print(restTemplate.getForEntity(urlForPopularMovies, MoviePage.class).getBody());
		return restTemplate.getForEntity(urlForPopularMovies, MoviePage.class).getBody();
	}


	// TODO: Is there a way to read only once from DB, or save only once?
	@Override
	public MovieCardCacheItem getMovieDetailsById(int id) {
		String urlForPopularMovies = apiUrl + "/movie/" + id + "?api_key=" + apiKey;
		// System.out.println(urlForPopularMovies);
		return movieCardCache.add(restTemplate.getForEntity(urlForPopularMovies, MovieCardCacheItem.class).getBody());
	}
}