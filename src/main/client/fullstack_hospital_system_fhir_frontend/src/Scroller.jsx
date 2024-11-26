function Scroller() {
    
    const items = ["Whatever", "Sup", "Yeah"]
    
    return(
        <div className="scroller">
            {items.map((item) => {
                return(
                    <div className="item">
                        <h1>{item}</h1>
                    </div>
                );
            })}
        </div>
    );

}

export default Scroller