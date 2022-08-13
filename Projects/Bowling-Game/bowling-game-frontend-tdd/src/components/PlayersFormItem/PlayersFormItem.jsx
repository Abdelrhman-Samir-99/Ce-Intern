import React from "react";
import { useDispatch } from "react-redux";
import { deletePlayer } from '../../redux/playerSlice';


const PlayersFormItem = ({id, name, rolls}) => {
    const dispatch = useDispatch();

    const deleteHandler = (event) => {
        event.preventDefault();
        console.log(id);
        dispatch(
            deletePlayer({
                    id: id
                }
            )
        );
    }

    return (
        <li className="list-group-item list-group-item-success">
            <div className="d-flex justify-content-between">
                <span className = "d-flex align-items-center">
                    {name}
                </span>
                <button onClick={deleteHandler} className="btn btn-danger">
                    Delete
                </button>
            </div>
        </li>
    );
};


export default PlayersFormItem;