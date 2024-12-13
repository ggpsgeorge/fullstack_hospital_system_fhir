import Profile from "./Profile";
import { useState, useEffect } from "react";

function HospitalScroller() {

    const [jsonItems, setJsonItems] = useState([])

    useEffect(() => {
        const fetchData = async() => {
            let url = 'http://localhost:8181/api/organization/v1/'
            const response = await fetch(url)
            const data = await response.json()
            setJsonItems(data)
        }

        fetchData()
            .catch(console.error);

    })

    if(!jsonItems.length) {
        return(
            <div className="scroller-hospital">
                <Profile name="Loading ..."></Profile>
            </div>
        );
    }

    return(
        <div className="scroller-hospital">
            {jsonItems.map((item) => {
                return(
                    <div>
                        <Profile name={item.name}></Profile>
                    </div>
                );
            })}
        </div>
    );
}

export default HospitalScroller;