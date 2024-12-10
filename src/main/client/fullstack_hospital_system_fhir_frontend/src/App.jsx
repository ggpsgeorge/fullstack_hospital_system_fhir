import './App.css'
import Profile from './Profile';
import Scroller from './Scroller';

import { useState, useEffect } from 'react';

function App() {
  
  const [resourceType, setResourceType] = useState("Patient")
  const handleResourceTypeChange = (event) => {
    setResourceType(event.target.value)
  }

  return(
    <>
      {/* <Profile name="Profile Name"></Profile> */}
      <h2>Hospital Management System</h2>
      <select name={resourceType} onChange={handleResourceTypeChange}>
        <option>Select a list</option>
        <option value="Patient">Patients</option>
        <option value="Practioner">Doctors</option>
        <option value="Organization">Hospitals</option>
      </select>
      <p>Resource Type: {resourceType} </p>
      <Scroller resourceType={resourceType}></Scroller>
      {/* <Scroller resourceType="Practioner"></Scroller> */}
    </>
  );
  
}

export default App
