# Overview

Fullstack project that uses Spring Boot for the backend and Vite for the frontend.

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

To populate the database you can use the JSON generated examples with a post method on localhost:8181/api/patient/v1/ with a list of patients.

JSON ResourceTypes response examples: 

[ResourceType Patient](data/generated-json/patients_generated.json)

[ResourceType Practioner, i.e, Doctor](data/generated-json/practioner_generated.json)

[ResourceType Organization, i.e, Hospital](data/generated-json/organization_generated.json)

# Frontend

WORKING IN PROGRESS

The frontend is made using Vite.

Install dependencies and run the frontend: 
```sh
cd src/main/client/fullstack_hospital_system_fhir_frontend
npm install
npm run dev
```
