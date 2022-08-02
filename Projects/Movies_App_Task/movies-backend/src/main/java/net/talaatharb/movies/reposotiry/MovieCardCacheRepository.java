package net.talaatharb.movies.reposotiry;

import org.springframework.data.jpa.repository.JpaRepository;

import net.talaatharb.movies.model.MovieCardCache;

public interface MovieCardCacheRepository extends JpaRepository<MovieCardCache, Integer>{
	
}
