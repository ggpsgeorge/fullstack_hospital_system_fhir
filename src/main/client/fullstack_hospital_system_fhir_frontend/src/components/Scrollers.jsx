import { useEffect, useState } from "react";
import PrimaryScroller from "./PrimaryScroller";
import SecondaryScroller from "./SecondaryScroller";
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';


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
        console.log(hospitalId)

        hospitalsItems.map((hospital, _) => {
            if(hospital.id === hospitalId) {
                setPatients(hospital.patients)
            }
        })

    }

    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const [patient, setPatient] = useState(null)

    function handleClickPatient(event, patientsItems) {
        const patientId = event.target.id
        
        patientsItems.map((patient, index) => {
            if(patient.id === patientId) {
                setPatient(patients[index])
            }
        })
        // MODAL SHOW
        handleShow()
    }

    

    if(!hospitals.length) {
        <div>
            <p>Loading...</p>
        </div>
    }

    return ( 
        <div>
            <div style={{display:"flex"}}>
                <div onClick={(event) => handleClickHospital(event, hospitals)}>
                    <PrimaryScroller hospitals={hospitals}></PrimaryScroller>
                </div>
                <div onClick={(event) => handleClickPatient(event, patients)}>
                    <SecondaryScroller data={patients}></SecondaryScroller>
                </div>
            </div>
            <div>
                <Modal show={show} onHide={handleClose}>
                    <Modal.Header closeButton>
                    <Modal.Title>Modal heading</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>{JSON.stringify(patient)}</Modal.Body>
                    <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={handleClose}>
                        Save Changes
                    </Button>
                    </Modal.Footer>
                </Modal>
            </div>
            {/* <p>{JSON.stringify(hospitals)}</p>
            <br></br>
            <p>{JSON.stringify(patients)}</p> */}
        </div>
     );
}

export default Scrollers;