import './App.css'
import Profile from './Profile';
import Scroller from './Scroller';

import { useState, useEffect } from 'react';

function App() {
    
  return(
    <>
      <Profile name="Profile Name"></Profile>
      <Scroller resourceType="Patient"></Scroller>
      <Scroller resourceType="Practioner"></Scroller>
    </>
  );
  
}

export default App
