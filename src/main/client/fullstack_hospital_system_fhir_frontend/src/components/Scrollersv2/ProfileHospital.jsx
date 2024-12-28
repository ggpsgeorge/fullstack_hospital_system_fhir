function ProfileHospital({hospital}) {
    return(
        <div className="profile">
            <h2 id={hospital.id}>{hospital.name}</h2>
        </div>
    );
}

export default ProfileHospital