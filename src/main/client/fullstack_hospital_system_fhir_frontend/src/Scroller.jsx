import Profile from "./Profile";
import { useState, useEffect } from "react";

function Scroller(props) {

    const [jsonItems, setJsonItems] = useState([])

    const handleClick = (data) => {
        console.log(data)
    } 

    useEffect(() => {
        const fetchData = async() => {
            let url = ''
            if(props.resourceType === 'Patient') {
                url = 'http://localhost:8181/api/patient/v1/'
            } else if(props.resourceType === 'Practioner') {
                url = 'http://localhost:8181/api/practioner/v1/'
            }
            const response = await fetch(url)
            const data = await response.json()
            setJsonItems(data)
            return data
        }

        fetchData()
            .catch(console.error);

    }, [])
    
    if(!jsonItems.length) {
        return(
            <div className="scroller">
                <Profile name="Loading ..."></Profile>
            </div>
        );
    }

    return(
        <div className="scroller">
            {jsonItems.map((item) => {
                return(
                    <div onClick={() => handleClick(item)}>
                        <Profile name={item.name[0].given[0] + ` ` + item.name[0].family}></Profile>
                    </div>
                );
            })}
        </div>
    );

}

export default Scroller