import React, { useState } from 'react'
import "./MovieSearchBar.css"


const MoviesSearchBar = () => {

    const [searchTerm, setSearchTerm] = useState('');

    const searchHandler = (e) => {
        e.perventDefault();
        if(searchTerm.length > 2) {
            // I should fetch the data here
            // console.log(searchTerm)
        }
        setSearchTerm('');
    }

    const onChangeHandler = (e) => {
        console.log(e.target.value);
        setSearchTerm(e.target.value)
        
    }

    return (
    <header>
        <form onSubmit={searchHandler}>
            <input className='search' type = "text" 
                placeholder='Search...'
                value = {searchTerm}
                onChange = {onChangeHandler}/>
            
        </form>
    </header>
  )
}

export default MoviesSearchBar