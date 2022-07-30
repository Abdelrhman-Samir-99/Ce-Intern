  export const shuffle = (array) => {
    return [...array].sort(() => Math.random() - 0.5)
  }
  
  export const createBoard = (row, col) => {
    let board = [];
    let counter = 0;
    for(var r = 0; r < row; ++r) {
     board[r] = []
     for(var c = 0; c < col; ++c) {
        board[r][c] = counter++;
      }
    }
    return board;
  }
  
  export const hasWon = (array) => {
    let counter = 0;
    let flag = true;
    for(var r = 0; r < 4; ++r) {
      for(var c = 0; c < 4; ++c) {
        flag &= (array[r][c] === counter++);
      }
    }

    if(flag === true) { return flag;}

    counter = 1;
    flag = true;
    for(r = 0; r < 4; ++r) {
      for(c = 0; c < 4; ++c) {
        if(array[r][c] === 0) {
          continue;
        }
        flag &= (array[r][c] === counter++);
      }
    }
    return flag;
  }

  export const cellsSwitchHandler = (emptyPositionIndex, currentPositionIndex, grid, setGrid, setEmptyCellIndex, gameState)=> {
    if(gameState === true) {
      return;
    }

    if(Math.abs(emptyPositionIndex[0] - currentPositionIndex[0]) + 
        Math.abs(emptyPositionIndex[1] - currentPositionIndex[1]) === 1) {
          let tempState = [...grid];
          tempState[emptyPositionIndex[0]][emptyPositionIndex[1]] = tempState[currentPositionIndex[0]][currentPositionIndex[1]];
          tempState[currentPositionIndex[0]][currentPositionIndex[1]] = 0;
          setGrid(() => [...tempState]);
          setEmptyCellIndex(findEmptyCell(grid));
        }
  }

  export const findEmptyCell = (grid) => {
    for(var r = 0; r < 4; ++r) {
      for(var c = 0; c < 4; ++c) {
        if(grid[r][c] === 0) {
          return [r, c];
        }
      }
    }
  }
