package net.talaatharb.movies.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import net.talaatharb.movies.dtos.MovieCard;
import net.talaatharb.movies.dtos.MoviePage;
import net.talaatharb.movies.model.MovieCardCache;
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
	public MovieCardCache getMovieDetailsById(int id) {
		String urlForPopularMovies = apiUrl + "/movie/" + id + "?api_key=" + apiKey;
		// System.out.println(urlForPopularMovies);
		Optional<MovieCardCache> movieCard = movieCardCacheReposoitry.findById(id);
		
		
		if(movieCard.isPresent()) {
			System.out.println("DIDNT HIT DB");
			return movieCard.get();
		}
		
		System.out.println("DID HIT THE DB");
		
		
		return movieCardCacheReposoitry.save(restTemplate.getForEntity(urlForPopularMovies, MovieCardCache.class).getBody());
	}
}