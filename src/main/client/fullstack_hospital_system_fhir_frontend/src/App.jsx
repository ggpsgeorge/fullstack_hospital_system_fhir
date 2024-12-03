import './App.css'
import Profile from './Profile';
import Scroller from './Scroller';

import { useState, useEffect } from 'react';

function App() {

  let newItems = [
    {id: 0, value: "Whatever"}, 
    {id: 1, value: "Sup"}, 
    {id: 2, value: "Yeah"}]

    const [patients, setPatients] = useState([])
    const [url, setUrl] = useState('http://localhost:8181/api/patient/v1/')

    useEffect(() => {
        const fetchData = async() => {
            const response = await fetch(url)
            const data = await response.json()
            setPatients(data)
            return data
        }

        fetchData()
            .catch(console.error);

    }, [])

  return(
    <>
      <Profile name="Profile Name"></Profile>
      <Scroller patients={patients}></Scroller>
    </>
  );
  
}

export default App
