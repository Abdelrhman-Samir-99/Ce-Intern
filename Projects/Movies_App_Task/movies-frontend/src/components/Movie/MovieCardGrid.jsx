import React, { useEffect, useState } from "react";
import MoviesSearchBar from "../SearchBar/MoviesSearchBar";
import MovieCard from "./MovieCard";

const getPopularMoviesUrl = "http://localhost:8080/movies?page=1";

const MovieCardGrid = () => {
    const [popularMovies, setPopularMovies] = useState([]);
    
    useEffect(() => {
        fetch(getPopularMoviesUrl).then(res => res.json()).then(data => {
            setPopularMovies(data.results);
        })
     }, [])

    return (
        <>
        <MoviesSearchBar/>
        <div className="movieCard-container"> 
        {
            popularMovies.length > 0 && popularMovies.map((movie) => <MovieCard key = {movie.id} id = {movie.id} title = {movie.title} poster_path = {movie.poster_path} vote_average = {movie.vote_average} overview = {movie.overview}/>)
        }
        </div>
        </>
    );
}

export default MovieCardGrid;
