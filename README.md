# Overview

Fullstack project that uses Spring Boot for the backend and Next.js for the frontend.

Hospital Management System to manage Patients, Hospitals and Doctors data.

# Backend

Simple REST API CRUD consuming and producing FHIR HL7 formats in JSON. Used the Patient and Organization ResourceType for this project. 

The data folder has examples of the format. The schemas produced were based on the data folder generated files.

All business logic is being done on the Controller layer, for simplicity.

The default server port is localhost:8181

To run the backend:

```sh
docker compose up 
mvn spring-boot:run
```

To populate the database you can use the JSON generated examples with a post method on localhost:8181/api/patient/v1/ with a list of patients.

JSON ResourceTypes response examples: 

[ResourceType Patient](data/generated-json/patients_generated.json)

[ResourceType Organization](data/generated-json/organization_generated.json)

# Frontend

WORKING IN PROGRESS
The frontend is made using Next.js.

Install dependencies and run the frontend: 
```sh
npm install
npm start dev
```
