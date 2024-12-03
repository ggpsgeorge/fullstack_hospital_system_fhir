import Profile from "./Profile";

function Scroller(props) {
    
    if(!props.patients.length) {
        return(
            <div className="scroller">
                <Profile></Profile>
            </div>
        );
    }

    return(
        <div className="scroller">
            {props.patients.map((patient) => {
                return(
                    <div>
                        <Profile name={patient.name[0].given[0]}></Profile>
                    </div>
                );
            })}
        </div>
    );

}

export default Scroller