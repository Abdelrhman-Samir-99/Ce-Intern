// This is the reducers & states of the player
import {createSlice} from '@reduxjs/toolkit'
import uuid from 'react-uuid';

const playerSlice = createSlice({
    name: "players",
    initialState: [
        {id: 1, name: "Ahmed", rolls: []},
    ],
    reducers: {
        // actions
        addPlayer: (state, action) => {
            // action has a payload
            const newPlayer = {
                id: uuid(),
                name: action.payload.name,
                rolls: []
            };
            console.log(newPlayer.id);

            state.push(newPlayer);
        },
        deletePlayer: (state, action) => { return state = state.filter(({id}) => { 
                    return id !== action.payload.id
                }
            );
        },
    }
})

export const {addPlayer, deletePlayer} = playerSlice.actions;
export default playerSlice.reducer;