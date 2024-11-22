# Overview

Fullstack project that uses Spring Boot for the backend and Next.js for the frontend.

Hospital Management System. Manage Patiente and Hospital data.

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

JSON response example of ResourceType Patient.

```json
{
	"resourceType": "Patient",
	"id": "patient-1",
	"name": [
		{
			"use": "official",
			"family": "Smith",
			"given": [
				"John"
			]
		}
	],
	"gender": "male",
	"birthDate": "1985-02-15",
	"address": [
		{
			"use": "home",
			"line": [
				"456 Oak Street"
			],
			"city": "Los Angeles",
			"state": "CA",
			"postalCode": "90001",
			"country": "USA"
		}
	]
}
```
JSON response example of ResourceType Organizaiton: 
```json
{
    "resourceType": "Organization",
    "id": "hospital-1",
    "name": "City General Hospital",
    "type": [
      {
        "coding": [
          {
            "system": "http://terminology.hl7.org/CodeSystem/organization-type",
            "code": "prov",
            "display": "Healthcare Provider"
          }
        ]
      }
    ],
    "telecom": [
      {
        "system": "phone",
        "value": "+1-800-555-001",
        "use": "work"
      },
      {
        "system": "email",
        "value": "contact@citygeneralhospital.org",
        "use": "work"
      }
    ],
    "address": [
      {
        "line": ["123 Main Street"],
        "city": "Metropolis",
        "state": "NY",
        "postalCode": "10001",
        "country": "US"
      }
    ]
}
```

# Frontend

WORKING IN PROGRESS
The frontend is made using Next.js.

Install dependencies and run the frontend: 
```sh
npm install
npm start dev
```

# Future
Manager other data resources types like Practioner(Doctor), PractionerRole(Doctor), Organization(Hospital) and Location(Hospital).