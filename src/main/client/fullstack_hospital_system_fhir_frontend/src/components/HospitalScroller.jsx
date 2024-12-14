import Profile from "./Profile";
import { useState, useEffect, useContext } from "react";

function HospitalScroller({hospitals, onClick}) {

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
                        <Profile name={item.name}></Profile>
                    </div>
                );
            })}
        </div>
    );
}

export default HospitalScroller;