package net.talaatharb.movies.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.talaatharb.movies.dtos.MoviePage;


@RequestMapping("/search")
@CrossOrigin(origins = "*")
public interface ISearchController {
	@GetMapping
	public ResponseEntity<Object> searchMoviesByName(@RequestParam String name);
}