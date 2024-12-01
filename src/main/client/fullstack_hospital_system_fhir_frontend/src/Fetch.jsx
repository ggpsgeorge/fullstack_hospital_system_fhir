import { useState, useEffect } from "react";

function Fetch() {
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

    return (
        <div>
        {JSON.stringify(patient)}
        </div>
    )
}

export default Fetch