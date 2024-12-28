function ProfilePatient({patient}) {
    return(
        <div className="profile">
            <h2 id={patient.id}>{patient.name[0].given[0] + ` ` + patient.name[0].family}</h2>
        </div>
    );
}

export default ProfilePatient