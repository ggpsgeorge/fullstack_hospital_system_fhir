import './App.css'
import HospitalScroller from './components/HospitalScroller';
import Scroller from './components/Scroller';

import { useState, useEffect } from 'react';

function App() {
  
  const [resourceType, setResourceType] = useState("Patient")
  const handleResourceTypeChange = (event) => {
    setResourceType(event.target.value)
  }

  return(
    <>
      <div className='home'>
        <h2 className='title'>Hospital Management System</h2>
        <HospitalScroller></HospitalScroller>
        <select className='patient-doctor-select' name={resourceType} onChange={handleResourceTypeChange}>
          <option>Select a list</option>
          <option value="Patient">Patients</option>
          <option value="Practioner">Doctors</option>
          <option value="Organization">Hospitals</option>
        </select>
        <p>Resource Type: {resourceType} </p>
        <Scroller resourceType={resourceType}></Scroller>
        {/* <Scroller resourceType="Practioner"></Scroller> */}
      </div>
    </>
  );
  
}

export default App
