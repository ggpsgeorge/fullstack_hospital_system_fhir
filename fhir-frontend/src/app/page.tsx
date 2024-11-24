'use client'

import MyButton from "./components/Button";
import Header from "./components/Header";
// import { useState, useEffect } from "react";

export default function App() {

  // const [data, setData] = useState([])

  // useEffect(() => {
  //   fetch('localhost:8181/api/patient/v1/patient-1')
  //     .then(response => response.json())
  //     .then(data => setData(data))
  // }, [])

  return (
    <div>
      <Header />
      <MyButton buttonName="Patient" />
      {/* {data.map(item => (
        <p>{item}</p>
      ))} */}
    </div>
  );
}
