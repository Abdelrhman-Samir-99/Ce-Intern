import React from "react";
import "./Cell.css"

const Cell = ({value, row, col, cellsSwitchHandler, emptyCellIndex, setEmptyCellIndex, grid, setGrid, gameState}) => {

    const switchHandler = cellsSwitchHandler;

    if(value === 0) {
        return (
            <div className = "emptyCell"></div>
        )
    }

    return (
        <div className = "filledCell" onClick = {() => switchHandler(emptyCellIndex, [row, col], grid, setGrid, setEmptyCellIndex, gameState)}>
            {value}
        </div>
    )
}

export default Cell;