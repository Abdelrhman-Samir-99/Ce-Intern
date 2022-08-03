import React from "react";
import "./MovieDetails.css";

const IMG_URL = `https://image.tmdb.org/t/p/w500/`;

const MovieDetails = ({
  title,
  overview,
  poster_path,
  backdrop_path,
  vote_average,
  vote_count,
  adult,
  release_date,
  original_title,
  revenue,
}) => {
  return (
    <>
      <div className="movieBackdrop">
        <div className="movieContainer">
          <img src={IMG_URL + poster_path} alt={title} className="moviePoster"></img>
          <section className="movieInfo">
            <p className="infoTitle">
              Title: <span className="infoContent"> {title} </span>
            </p>
            <p className="infoTitle">
              Average Rating:{" "}
              <span className="infoContent">{vote_average}</span>
            </p>
            <p className="infoTitle">
              Average Rating:{" "}
              <span className="infoContent">{vote_count}</span>
            </p>
            <p className="infoTitle">
              Overview:{" "}
              <span className="infoContent"> {overview}</span>
            </p>
            <p className="infoTitle">
              Release Date:{" "}
              <span className="infoContent">{release_date}</span>
            </p>
            <p className="infoTitle">
              Runtime:{" "}
              <span className="infoContent"> This is the duration </span>
            </p>
            <p className="infoTitle">
              Original Title: <span className="infoContent">{original_title} </span>
            </p>
            <p className="infoTitle">
              Revenue: <span className="infoContent">{revenue} </span>
            </p>
    
          </section>
        </div>
      </div>
    </>
  );
};

export default MovieDetails;
