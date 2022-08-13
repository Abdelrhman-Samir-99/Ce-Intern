import React, {useEffect} from "react";
import { useSelector } from "react-redux";
import PlayersFormItem from "../PlayersFormItem/PlayersFormItem";

const PlayersFormList = () => {
    const Players = useSelector((state) => state.players)
    
    return (
        <div className="list-group">
            <ul>
                {
                    Players.map((Player) => (
                        <PlayersFormItem name = {Player.name} rolls = {Player.rolls}/>  
                    ))
                }
            </ul>
        </div>
    );
};

export default PlayersFormList;