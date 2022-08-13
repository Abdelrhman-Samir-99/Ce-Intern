import React from 'react'
import Frame from '../Frame'

const PlayerFrame =  ({playerName, framesNumber = 10}) => {
  return (
    <div>
        <span>
        <h1>{playerName}</h1> 
          {
              [...Array(framesNumber)].map((index) => <Frame isLastFrame={index === framesNumber - 1}/>)
          }
        </span>
    </div>
  )
}


export default PlayerFrame;