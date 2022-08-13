import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import PlayersForm from './components/Register/PlayersForm'
import PlayersFormList from './components/PlayersFormList/PlayersFormList';

function App() {
  return (
    <div className='container bg-white p-4 mt-5'>
			<h1>My Todo List</h1>
      <PlayersForm/>
      <PlayersFormList/>
		</div>
  );
}

export default App;
