package net.talaatharb.movies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@RequiredArgsConstructor
public class MovieCardCache {
	@Id
	Integer id;
    String title;
    @Column(columnDefinition = "LONGTEXT", length = 100000)
    String overview;
    String poster_path;
    String backdrop_path;
    int vote_average;
    int vote_count;
    boolean adult;
    String release_date;
    String original_title;
    String revenue;
}