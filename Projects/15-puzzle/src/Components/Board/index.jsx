import React, { useEffect, useState } from "react";
import { createBoard, shuffle, cellsSwitchHandler, findEmptyCell, hasWon } from "../../utils/helpers";
import Cell from "../Cell";
import "./Board.css"


const Board = () => {
    const [grid, setGrid] = useState(shuffle(createBoard(4, 4)));
    const [emptyPositionIndex, setEmptyPositionIndex] = useState(() => { findEmptyCell(grid)})
    const [gameState, setGameState] = useState(() => hasWon(grid))
    // const [counter, setCounter] = useState(0);

    useEffect(() => {
        const grid = shuffle(createBoard(4, 4));
        setEmptyPositionIndex(findEmptyCell(grid));
        setGrid(grid);
    }, [])

    useEffect(()=> {
        setGameState(hasWon(grid));
    }, [grid])

    console.log(emptyPositionIndex);
    return (
        <div>
            <header className = "Board-header">
                <div className = "Board">
                    {
                        grid.map((rowData, rowIndex) => {
                            return rowData.map((cell, colIndex) => {
                                return <Cell 
                                    value = {cell}
                                    row = {rowIndex}
                                    col = {colIndex}
                                    cellsSwitchHandler = {cellsSwitchHandler}
                                    emptyCellIndex = {emptyPositionIndex}
                                    setEmptyCellIndex = {setEmptyPositionIndex}
                                    grid = {grid}
                                    setGrid = {setGrid}
                                    state = {gameState}
                                    />
                            })
                        })
                    }
                </div>
            </header>
        </div>
    )
}

export default Board;