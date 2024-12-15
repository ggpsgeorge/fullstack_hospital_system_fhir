import Profile from "./Profile";
import { useState, useEffect, useContext } from "react";
import ProfileHospital from "./ProfileHospital";

function PrimaryScroller({hospitals, onClick}) {

    const [jsonItems, setJsonItems] = useState([])

    useEffect(() => {
        setJsonItems(hospitals)
    }, [hospitals])

    if(!jsonItems.length) {
        return(
            <div className="scroller-hospital">
                <Profile name="Loading ..."></Profile>
            </div>
        );
    }

    return(
        <div className="scroller-hospital">
            {jsonItems.map((item, index) => {
                return(
                    <div key={index}>
                        <ProfileHospital hospital={item}></ProfileHospital>
                    </div>
                );
            })}
        </div>
    );
}

export default PrimaryScroller;