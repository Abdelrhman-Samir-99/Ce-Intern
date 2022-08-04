import React from "react";
import { Link } from "react-router-dom";
import "./MovieCard.css"

const IMG_URL = `https://image.tmdb.org/t/p/w500/`

const setVoteColor = (vote) => {
    if(vote >= 8) {
        return "green";
    } else if(vote >= 6) {
        return "orange";
    }
    else {
        return "red";
    }
}


const MovieCard = ({id, title, poster_path, overview, vote_average}) => {
    
    const path = "/movies/" + id;

    return (
        <Link to = {path} className="movieCard">
        <div >
            <img src = {IMG_URL + poster_path} alt = {title}></img>
            <div className="movieCard-info">
                <h3>{title}</h3>
                <span className={`tag ${setVoteColor(vote_average)}`}>{vote_average}</span>
            </div>

            <div className="movieCard-over">
                <h2>Overview: </h2>
                <p>{overview}</p>
            </div>
        </div>
        </Link>
    );
}

export default MovieCard;