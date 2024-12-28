import { useEffect, useState } from "react";
import PrimaryScroller from "./PrimaryScroller";

import { patientTest } from "../testVars";


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

    function handleClickHospital(event, hospitalsItems) {
        const hospitalId = event.target.id

        hospitalsItems.map((hospital, _) => {
            if(hospital.id === hospitalId) {
                setPatients(hospital.patients)
            }
        })

    }

    const [show, setShow] = useState(false);
    const handleShow = () => setShow(true);

    const [patient, setPatient] = useState(patientTest)

    function handleClickPatient(event, patientsItems) {
        const patientId = event.target.id
        
        patientsItems.map((patient, index) => {
            if(patient.id === patientId) {
                setPatient(patients[index])
            }
        })
        
        handleShow()

    }

    return ( 

        !hospitals.length ?
            <div>
                <p>Loading...</p>
            </div>
        :
        <div>
            <div className="scrollers">
                <div className="scrollers-title" onClick={(event) => handleClickHospital(event, hospitals)}>
                    <h3>Hospitals</h3>
                    <PrimaryScroller hospitals={hospitals}></PrimaryScroller>
                </div>
            </div>
            {/* <p>{JSON.stringify(hospitals)}</p> */}
            {/* <p>{JSON.stringify(patients)}</p> */}
            {/* <p>{JSON.stringify(patient)}</p> */}
            {/* <p>{JSON.stringify(show)}</p> */}
        </div>
     );
}

export default Scrollers;