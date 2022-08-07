package net.talaatharb.movies.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.talaatharb.movies.services.IMovieService;


@RestController
@RequiredArgsConstructor
public class MoviesController implements IMoviesController {
	
	@Autowired
	IMovieService movieService;
	
	@Override
	public ResponseEntity<Object> getPopularMovies(@RequestParam int page) {
		return new ResponseEntity<> (movieService.getPopularMoviesPage(page), HttpStatus.OK);
	}


	@Override
	public ResponseEntity<Object> getMovieById(@PathVariable int id) {
		return new ResponseEntity<> (movieService.getMovieDetailsById(id), HttpStatus.OK);
	}
}
