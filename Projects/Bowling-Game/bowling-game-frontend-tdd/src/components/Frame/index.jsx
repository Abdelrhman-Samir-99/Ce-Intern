import React, {useState} from 'react';
import './index.css';

const Frame = ({isLastFrame}) => {
  const [firstRoll, setFirstRoll] = useState('-');
  const [secondRoll, setSecondRoll] = useState('-');
  const [thirdRoll, setThirdRoll] = useState('-');
 
  const firstRollChangeHandler = (event) => {
    setFirstRoll(event.target.value);
  }

  const secondRollChangeHandler = (event) => {
    setSecondRoll(event.target.value);
  }
  
  const thirdRollChangeHandler = (event) => {
    setThirdRoll(event.target.value);
  }

  return (
    <div className="frame-container">
        <span>
        <input type = "text" className='frame-container' value = {firstRoll} onChange = {firstRollChangeHandler}/> 
        <input type = "text" className='frame-container' value = {secondRoll} onChange = {secondRollChangeHandler}/>
        {isLastFrame === true ? <input type = "text" className='frame-container' value = {thirdRoll}/> : null}
        </span>
        <hr/>
        <h3 className='frame-container'>1</h3>
    </div>
  )  
}
export default Frame;
