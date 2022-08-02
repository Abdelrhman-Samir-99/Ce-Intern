package net.talaatharb.movies.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/movies")
@CrossOrigin(origins = "*")
public interface IMoviesController {
	@GetMapping("/popular")
	public ResponseEntity<Object> getPopularMovies(@RequestParam int page);
	@GetMapping("/{id}")
	public ResponseEntity<Object> getMovieById(@PathVariable int id);
}
