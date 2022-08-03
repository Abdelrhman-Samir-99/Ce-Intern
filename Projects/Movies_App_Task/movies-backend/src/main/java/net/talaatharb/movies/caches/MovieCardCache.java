package net.talaatharb.movies.caches;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.talaatharb.movies.model.MovieCardCacheItem;
import net.talaatharb.movies.reposotiry.MovieCardCacheRepository;

@Component
public class MovieCardCache implements IMovieCardCache {

	@Autowired
	MovieCardCacheRepository movieCardCacheReposoitry;
	
	@Override
	public MovieCardCacheItem add(MovieCardCacheItem movieCard) {
		Optional<MovieCardCacheItem> movieCardCached = search(movieCard.getId());
		if(movieCardCached.isPresent()) {
			System.out.println("DID NOT HIT DB");
			return movieCardCached.get();
		}
		
		/*
		 TODO: Ask Yara how to fix this (Go to the repository and show her the native query).
		if(movieCardCacheReposoitry.count() == 1) {
			movieCardCacheReposoitry.deleteTopRow();
			System.out.println("HEYEYEEYEYEYE");
			System.out.println(movieCardCacheReposoitry.count());
		}
		*/
		System.out.println("DID HIT THE DATABASE");
		return movieCardCacheReposoitry.save(movieCard);
	}

	@Override
	public Optional <MovieCardCacheItem> search(int id) {
		return movieCardCacheReposoitry.findById(id);
	}
	
}
