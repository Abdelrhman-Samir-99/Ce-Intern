package net.talaatharb.movies.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.talaatharb.movies.dtos.MoviePage;
import net.talaatharb.movies.services.ISearchService;




@RestController
@RequiredArgsConstructor
public class SearchController implements ISearchController {
	@Autowired
	ISearchService searchService;
	
	@Override
	public ResponseEntity<Object> searchMoviesByName(@RequestParam String name) {
		// TODO: Change the response to match if you had found it or not.
		return new ResponseEntity<>(searchService.searchMoviesByName(name), HttpStatus.OK);
	}

}
