package net.talaatharb.movies.dtos;

import lombok.Data;

@Data
public class MovieCard {
	Integer id;
    String title;
    String overview;
    String poster_path;
    String backdrop_path;
    Integer vote_average;
    Integer vote_count;
    boolean adult;
    String release_date;
    String original_title;
    String revenue;
}