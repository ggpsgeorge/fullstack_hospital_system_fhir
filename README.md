# Overview

Fullstack project that uses Spring Boot for the backend and Next.js for the frontend.

Hospital Management System. Manage Patients, Hospitals and Doctors data.

# Backend

Simple REST API CRUD consuming and producing FHIR HL7 formats in JSON. Used the Patient and Organization ResourceType for this project. 

The data folder has examples of the format. The schema produced was based on the patients_generated.json file attributes. 

All business logic is being done on the Controller layer, for simplicity.

To run the backend:

```sh
docker compose up 
mvn spring-boot:run
```
The default server port is localhost:8181.

[JSON response example](data/generated-json/patients_generated.json) of ResourceType Patient.

[JSON response example](data/generated-json/organization_generated.json) of ResourceType Organizaiton: 

# Frontend

WORKING IN PROGRESS
The frontend is made using Next.js.

Install dependencies and run the frontend: 
```sh
npm install
npm start dev
```
