// This is the reducers & states of the player
import {createSlice} from '@reduxjs/toolkit'

const playerSlice = createSlice({
    name: "players",
    initialState: [
        {name: "Ahmed", rolls: []},
        {name: "Abdelrhman", rolls: []}
    ],
    reducers: {
        // actions
        addPlayer: (state, action) => {
            // action has a payload
            const newPlayer = {
                name: "Abdelrhman Mohamed",
                rolls: []
            }

            state.push(newPlayer);
        }
    }
})

export const {addPlayer} = playerSlice.actions;
export default playerSlice.reducer;