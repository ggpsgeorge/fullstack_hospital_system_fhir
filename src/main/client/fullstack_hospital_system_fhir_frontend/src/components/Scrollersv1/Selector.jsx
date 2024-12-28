import { useContext } from "react";

export const resourceTypeContext = useContext();

function Selector() {
    return ( 
        <div>
            <select className='patient-doctor-select' onChange={handleResourceTypeChange}>
                <option>Select a list</option>
                <option value="Patient">Patients</option>
                <option value="Practioner">Doctors</option>
            </select>
        <p>Resource Type: {resourceType} </p>
        </div>
     );
}

export default Selector;