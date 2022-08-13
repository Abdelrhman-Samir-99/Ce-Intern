import { useSelector } from "react-redux";
import PlayersFormItem from "../PlayersFormItem/PlayersFormItem";

const PlayersFormList = () => {
    const Players = useSelector((state) => state.players)
    
    return (
        <div className="list-group">
            <ul>
                {
                    Players.map((Player) => (
                        <PlayersFormItem key = {Player.id} id = {Player.id} name = {Player.name} rolls = {Player.rolls}/>  
                    ))
                }
            </ul>
        </div>
    );
};

export default PlayersFormList;