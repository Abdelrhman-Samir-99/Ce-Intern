import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import PlayersForm from './components/Register/PlayersForm'
import PlayersFormList from './components/PlayersFormList/PlayersFormList';
import Frame from './components/Frame'
import PlayerFrame from './components/PlayerFrame';
import ScoringGrid from './components/ScoringGrid';

function App() {
  return (
    <div className='container bg-white p-4 mt-5'>
			<h1>Players Names</h1>
      <PlayersForm/>
      <PlayersFormList/>
      <ScoringGrid/>
		</div>
  );
}

export default App;
