import { useState } from "react";
import Scroller from "./Scroller";

function SelectionScroller() {

    const [resourceType, setResourceType] = useState("Patient")
    const handleResourceTypeChange = (event) => {
        setResourceType(event.target.value)
    }

    return ( 
        <div>
            <div className="scroller-patient-doctor">
                <select className='patient-doctor-select' name={resourceType} onChange={handleResourceTypeChange}>
                    <option>Select a list</option>
                    <option value="Patient">Patients</option>
                    <option value="Practioner">Doctors</option>
                </select>
                <Scroller resourceType={resourceType}></Scroller>
            </div>
            <div>
                <p>Resource Type: {resourceType} </p>
            </div>
        </div>
     );
}

export default SelectionScroller;