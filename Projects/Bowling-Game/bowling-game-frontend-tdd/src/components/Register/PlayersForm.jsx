import React, {useState} from 'react';
import { useDispatch } from 'react-redux';
import {addPlayer} from '../';

const PlayersForm = () => {
    const [value, setValue] = useState('');
    const dispatch = useDispatch()
    
    const onSubmitHandler = (event) => {
        event.preventDefault();
        if(value) {
            // TODO: dispatch here
            dispatch(
                addPlayer({
                    name: value,
                    rolls:[]
                })
            );
            console.log("HEYEY");
        }
    };

    return (
        <form onSubmit={onSubmitHandler} className= 'form-inline mt-3 mb-3'>
            <label className='sr-only'>Player Name</label>
            <input
                type = 'text'
                className='form-control mb-2 mr-sm-2'
                placeholder='Add player name...'
                value = {value}
                onChange = {(event) => setValue(event.target.value)}
            >
            </input>

            <button type = 'submit' className='btn btn-primary mb-2'>
                Add
            </button>
        </form>
    )
}

export default PlayersForm;