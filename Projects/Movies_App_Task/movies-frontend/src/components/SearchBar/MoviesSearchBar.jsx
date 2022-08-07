import React, { useState } from "react";
import { Link } from "react-router-dom";
import "./MovieSearchBar.css";


  const URL = "http://localhost:8080/search?name=";
  const URL2 = "https://api.themoviedb.org/3/search/movie?api_key=a97243d7813d31446f6c43284e6854d5&language=en-US&query=";
  const URL3 = "&page=1&include_adult=false";

const MoviesSearchBar = () => {
  const [options, setOptions] = useState(() => [])
  
  const getData = (word) => {
    if(word.length < 3)
      return;
    fetch(URL + word).then(res => res.json()).then(data => {
    setOptions(data.results);
    console.log(data.results);
  })}

  const fetchData = (e) => {
    getData(e.target.value);
  }

  
  return (
    <>
      <form >
        <input type='text' onChange={fetchData} className="search" />
      </form>
      <ul>
        {options.length &&  options.map((data) =>
            <Link to = {"/movies/" + data.id} key = {data.id}>
              <li>
                {data.original_title}
              </li>
            </Link>
        )}
      </ul>
    </>
  );
};

export default MoviesSearchBar;
