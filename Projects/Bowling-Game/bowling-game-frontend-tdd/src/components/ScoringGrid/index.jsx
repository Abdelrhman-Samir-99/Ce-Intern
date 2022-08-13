import React from 'react'
import { useEffect } from 'react';
import { useSelector } from "react-redux";
import PlayerFrame from '../PlayerFrame';

const ScoringGrid = () => {
  const Players = useSelector((state) => state.players)
  
  return (
    <div>
    {
        Players.map((player) =>(
            <PlayerFrame playerName = {player.name}/>
        ))
    }
    </div>
  )
}

export default ScoringGrid