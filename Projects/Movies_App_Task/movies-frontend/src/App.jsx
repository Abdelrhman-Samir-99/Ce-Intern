import React from "react"
import MovieCardGrid from './components/Movie/MovieCardGrid'
import MovieDetails from "./components/Movie/MovieDetails";
import { BrowserRouter as Router, Route, Routes} from "react-router-dom";


function App() {
  return (
  <Router>
    <Routes>
      <Route path = "/movies" element = {<MovieCardGrid />} />
      <Route path = "/movies/:id" element= {<MovieDetails />} />
    </Routes>
  </Router>
  );
}

export default App;

