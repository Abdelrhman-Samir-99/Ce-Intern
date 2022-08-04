package net.talaatharb.movies.reposotiry;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.talaatharb.movies.model.MovieCardCacheItem;

public interface MovieCardCacheRepository extends JpaRepository<MovieCardCacheItem, Integer> {
	@Query(value = "Delete from MovieCardCacheItem where id = 616037", nativeQuery = true)
	@Transactional
	public void deleteTopRow();
	
}
