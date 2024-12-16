# Overview

Fullstack project that uses Spring Boot for the backend and Vite(React) for the frontend.

Hospital Management System to manage Patients, Hospitals and Doctors data.

# Backend

Simple REST API CRUD consuming and producing FHIR HL7 formats in JSON. Used the Patient, Organization and Practioner ResourceType for this project. 

The data folder has examples of the format. The schemas produced were based on the data folder generated files.

All business logic is being done on the Controller layer, for simplicity.

The default server port is localhost:8181

To run the backend:

```sh
docker compose up 
mvn spring-boot:run
```

To populate the database you can use the JSON generated examples with a post method on http://localhost:8181/api/patient/v1/, http://localhost:8181/api/organization/v1/, http://localhost:8181/api/practioner/v1/.

JSON ResourceTypes response examples: 

[ResourceType Patient](data/generated-json/patients_generated.json)

[ResourceType Practioner, i.e, Doctor](data/generated-json/practioner_generated.json)

[ResourceType Organization, i.e, Hospital](data/generated-json/organization_generated.json)

# Frontend

The frontend is made using Vite, React, CSS, HTML and Javascript.

The frontend manages only the hospital data and patient data.

Install dependencies and run the frontend: 
```sh
cd src/main/client/fullstack_hospital_system_fhir_frontend
npm install
npm run dev
```
The frontend is running at http://localhost:5173/ and the examples had the backend running on the background.

For the frontend, hospitals and patients are registered with the put method on http://localhost:8181/api/organization/v1//{id}/register-patient/{patientId}

The initial page:
![Initial Panel](/data/imgs/firstCrop.png "Initial Panel")

Choosing a Hospital:
![Choosing Hospital](/data/imgs/secondCrop.png "Choosing Hospital")

Choosing a Patient:
![Choosing Patient](/data/imgs/thirdCrop.png "Choosing Patient")