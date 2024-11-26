function Scroller(props) {
    
    let newItems = ["Whatever", "Sup", "Yeah"]
    let items = []
    items.push(props.name)
    newItems.forEach((item) => {
        items.push(item)
    })
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