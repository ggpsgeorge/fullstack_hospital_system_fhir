function PatientShow({patient, show}) {
    
    const gender = patient.gender[0].toUpperCase() + patient.gender.slice(1)
    const city = patient.address[0].city 
    const line = patient.address[0].line[0]  
    const state = patient.address[0].state 
    const country = patient.address[0].country 
    const postalCode = patient.address[0].postalCode

    if(show) {
        return ( 
            <div className="profile-patient">
                <h3>{patient.name[0].given[0] + ` ` + patient.name[0].family}</h3>
                <p>Gender: {gender}</p> 
                <p>Date of Birth: {patient.birthDate}</p>
                <p>Address: {line + `, ` + city + `, ` + state + ` - ` + country}</p>
            </div>
        );
    }

    return(null)
}

export default PatientShow;