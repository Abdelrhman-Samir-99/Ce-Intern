import React from "react";
import { Link } from "react-router-dom";
import "./MovieCard.css"

const IMG_URL = `https://image.tmdb.org/t/p/w500/`


const MovieCard = ({id, title, poster_path, overview, vote_average}) => {
    
    const path = "/movies/" + id;

    return (
        <Link to = {path} className="movieCard">
                <div className="img1">
                    <img src={IMG_URL + poster_path} alt={title}></img>
                </div>
                <div className="img2"></div>
                <div className="movieCard-info">
                    <div className="title">{title}</div>
                </div>

                <div className="movieCard-over">
                    <div className="text">{overview.substring(0, 150) + "..."}</div>
                </div>

                <div className="rating">
                    <img src='/star.png' alt={vote_average}/> {vote_average} 
                </div>
        </Link>
    );
}

export default MovieCard;