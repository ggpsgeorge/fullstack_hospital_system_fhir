import './App.css'

import { useState, useEffect } from 'react';
import Scrollers from './components/Scrollersv2/Scrollers';

function App() {
  
  return(
    <>
      <div className='home'>
        <h2 className='title'>Hospitals Panel</h2>
        <Scrollers></Scrollers>
      </div>
    </>
  );
  
}

export default App
