import './App.css'

import { useState, useEffect } from 'react';
import Scrollers from './components/Scrollers';

function App() {
  
  return(
    <>
      <div className='home'>
        <h2 className='title'>Hospital Management System</h2>
        <Scrollers></Scrollers>
      </div>
    </>
  );
  
}

export default App
