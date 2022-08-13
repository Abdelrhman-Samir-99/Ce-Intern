import { configureStore } from '@reduxjs/toolkit';
import playerReducer from './playerSlice'
export default configureStore({
	// This object holds all reducers
    reducer: {
		players: playerReducer,
	},
});