import Profile from "../components/Profile";
import { useState, useEffect } from "react";

function Scroller({resourceType}) {

    const [jsonItems, setJsonItems] = useState([])

    const handleClick = (data) => {
        console.log(data)
    } 

    useEffect(() => {
        const fetchData = async() => {
            let url = ''
            if(resourceType === 'Patient') {
                url = 'http://localhost:8181/api/patient/v1/'
            } else if(resourceType === 'Practioner') {
                url = 'http://localhost:8181/api/practioner/v1/'
            }
            const response = await fetch(url)
            const data = await response.json()
            setJsonItems(data)
            return data
        }

        fetchData()
            .catch(console.error);

    }, [resourceType])
    
    if(!jsonItems.length) {
        return(
            <div className="scroller">
                <Profile name="Loading ..."></Profile>
            </div>
        );
    }

    return(
        <div className="scroller">
            {jsonItems.map((item, index) => {
                return(
                    <div key={index} onClick={() => handleClick(item)}>
                        <Profile name={item.name[0].given[0] + ` ` + item.name[0].family}></Profile>
                    </div>
                );
            })}
        </div>
    );

}

export default Scroller