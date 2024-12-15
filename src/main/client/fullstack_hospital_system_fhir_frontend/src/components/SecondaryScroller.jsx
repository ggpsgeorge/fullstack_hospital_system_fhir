import Profile from "./Profile";
import { useState, useEffect } from "react";

function SecondaryScroller({resourceType, data}) {

    const [jsonItems, setJsonItems] = useState([])

    const handleClick = (dataItem) => {
        console.log(dataItem)
    } 

    useEffect(() => {
        
        setJsonItems(data)

    }, [data])
    
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
                        <Profile name={JSON.stringify(item)}></Profile>
                    </div>
                );
            })}
        </div>
    );

}

export default SecondaryScroller