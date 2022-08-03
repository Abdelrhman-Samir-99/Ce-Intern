package net.talaatharb.movies.caches;

import java.util.Optional;

import net.talaatharb.movies.model.MovieCardCacheItem;

public interface IMovieCardCache {
	public MovieCardCacheItem add(MovieCardCacheItem movieCard);
	public Optional <MovieCardCacheItem> search(int id);
}
