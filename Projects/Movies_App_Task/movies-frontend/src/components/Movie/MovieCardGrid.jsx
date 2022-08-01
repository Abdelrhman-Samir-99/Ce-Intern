import React, { useEffect, useState } from "react";
import MoviesSearchBar from "../SearchBar/MoviesSearchBar";
import MovieCard from "./MovieCard";

const getPopularMoviesUrl = "https://api.themoviedb.org/3/movie/popular?api_key=a97243d7813d31446f6c43284e6854d5&language=en-US&page=1";

const MovieCardGrid = () => {
    const [popularMovies, setPopularMovies] = useState([]);
    
    useEffect(() => {
        fetch(getPopularMoviesUrl).then(res => res.json()).then(data => {
        setPopularMovies(data.results);
        console.log(data.results);
        })
     }, [])

    return (
        <>
        <MoviesSearchBar/>
        <div className="movieCard-container"> 
        {
            popularMovies.length > 0 && popularMovies.map((movie) => <MovieCard key = {movie.id} title = {movie.title} poster_path = {movie.poster_path} vote_average = {movie.vote_average} overview = {movie.overview}/>)
        }
        </div>
        </>
    );
}

export default MovieCardGrid;
