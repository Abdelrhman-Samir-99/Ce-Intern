import React from "react";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import "./MovieDetails.css";

const IMG_URL = `https://image.tmdb.org/t/p/w500/`;
const movieURL = "http://localhost:8080/movies/";

const MovieDetails = () => {
  const [movieDetails, setMovieDetails] = useState({})
  const {id} = useParams();

  useEffect(() => {
    fetch(movieURL + id).then(res => res.json()).then(data => {
    setMovieDetails(data);
    }) // eslint-disable-next-line 
  }, [])

  
  return (
    <>
      <div className="movieBackdrop">
        <div className="movieContainer">
          <img src={IMG_URL + movieDetails.poster_path} alt={movieDetails.title} className="moviePoster"></img>
          <section className="movieInfo">
            <p className="infoTitle">
              Title: <span className="infoContent"> {movieDetails.title} </span>
            </p>
            <p className="infoTitle">
              Average Rating:{" "}
              <span className="infoContent">{movieDetails.vote_average}</span>
            </p>
            <p className="infoTitle">
              Average Rating:{" "}
              <span className="infoContent">{movieDetails.vote_count}</span>
            </p>
            <p className="infoTitle">
              Overview:{" "}
              <span className="infoContent"> {movieDetails.overview}</span>
            </p>
            <p className="infoTitle">
              Release Date:{" "}
              <span className="infoContent">{movieDetails.release_date}</span>
            </p>
            <p className="infoTitle">
              Runtime:{" "}
              <span className="infoContent"> This is the duration </span>
            </p>
            <p className="infoTitle">
              Original Title: <span className="infoContent">{movieDetails.original_title} </span>
            </p>
            <p className="infoTitle">
              Revenue: <span className="infoContent">{movieDetails.revenue} </span>
            </p>
    
          </section>
        </div>
      </div>
    </>
  );
};

export default MovieDetails;
