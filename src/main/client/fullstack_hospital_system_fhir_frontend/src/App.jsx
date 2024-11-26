import './App.css'
import Fetch from './Fetch';
import Profile from './Profile';
import Scroller from './Scroller';

import { useState, useEffect } from 'react';

function App() {

  const [patient, setPatient] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8181/api/patient/v1/patient-1')
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            console.log(data);
            setPatient(data);
        });
    }, []);

  return(
    <>
      <Fetch></Fetch>
      <Profile></Profile>
      <Scroller name={patient.id}></Scroller>
    </>
  );
  
}

export default App
