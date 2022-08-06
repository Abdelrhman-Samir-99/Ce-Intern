import React, { useState, useEffect } from "react";
import Select from "react-select";
import "./MovieSearchBar.css";

const options = [
  { value: "chocolate", label: "Chocolate" },
  { value: "strawberry", label: "Strawberry" },
  { value: "vanilla", label: "Vanilla", test: "TEST" },
];

const part1 =
  "https://api.themoviedb.org/3/search/movie?api_key=a97243d7813d31446f6c43284e6854d5&language=en-US&query=";
const part2 = "&page=1&include_adult=false";
const MoviesSearchBar = () => {
  const [suggestions, setSuggestions] = useState(options);
  const [searchTerm, setSearchTerm] = useState("");
  const [selectectedMovie, setSelectedMovie] = useState("");
  
  const fetchMoviesData = () => {
    fetch(part1 + searchTerm + part2)
      .then((res) => res.json())
      .then((data) => {
        setSuggestions(data.results);
      });
  };

  // This what happens when he clicks enter (will be changed)
  const searchHandler = (e) => {
    e.perventDefault();
    if (e.target.value.length > 2) {
      // I should fetch the data here
      // console.log(searchTerm)
      fetchMoviesData();
      console.log(suggestions);
      setSuggestions(suggestions);
    }
  };

  useEffect(() => {
    // This is not working and I don't know why
    console.log("HELOOOOOOOOOOOOOOOOOOOOOOOOO");
    if (searchTerm.length > 2) {
      setSuggestions(
        fetch(part1 + searchTerm + part2)
          .then((res) => res.json())
          .then((data) => {
            setSuggestions(data.results);
          })
      );
      console.log("ASFASFASF");
    }
  }, [searchTerm]);

  const handleChange = (searchTerm) => {
    setSearchTerm(searchTerm)
    console.log(searchTerm);
    // This is where I will redirect the URL
  };

  return (
    <header>
      <form onSubmit={searchHandler}>
        <Select
          className="search"
          value={searchTerm}
          onChange={handleChange}
          options={suggestions}
          placeholder="Search..."
        />
      </form>
    </header>
  );
};

export default MoviesSearchBar;
