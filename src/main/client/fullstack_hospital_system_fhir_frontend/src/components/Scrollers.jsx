import { createContext, useEffect, useState } from "react";
import PrimaryScroller from "./PrimaryScroller";
import SecondaryScroller from "./SecondaryScroller";

function Scrollers() {

    const [hospitals, setHospitals] = useState([])
    const [patients, setPatients] = useState([])

    const urlHospitals = 'http://localhost:8181/api/organization/v1/'

    useEffect(() => {
        const fetchHospitals = async (url) => {
          
            const response = await fetch(url)
            const data = await response.json()

            setHospitals(data)
        }

        fetchHospitals(urlHospitals)
            .catch(console.error)
        
    }, [])

    function handleClick(event, hospitalsItem) {
        const hospitalId = event.target.id
        console.log(hospitalId)

        hospitalsItem.map((hospital, _) => {
            if(hospital.id === hospitalId) {
                setPatients(hospital.patients)
            }
        })

    }

    if(!hospitals.length) {
        <div>
            <p>Loading...</p>
        </div>
    }

    return ( 
        <div>
            <div style={{display:"flex"}}>
                <div onClick={(event) => handleClick(event, hospitals)}>
                    <PrimaryScroller hospitals={hospitals}></PrimaryScroller>
                </div>
                <SecondaryScroller data={patients}></SecondaryScroller>
            </div>
            <p>{JSON.stringify(hospitals)}</p>
            <br></br>
            <p>{JSON.stringify(patients)}</p>
        </div>
     );
}

export default Scrollers;