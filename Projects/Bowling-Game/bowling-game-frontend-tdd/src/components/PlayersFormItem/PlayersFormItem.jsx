import React from "react";


const PlayersFormItem = ({name, rolls}) => {
    
    const deleteHandler = () => {}

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