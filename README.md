# Simple-REST-API-with-SpringBoot
Demo project which shows how to create a simple REST API using spring boot.

#1) Description
This project gives a high level overview of creating a simple REST API using spring boot. The REST API is related to performing simple CRUD (CREATE, RETRIEVE, UPDATE, DELETE) operations on a Customer object.
The API allows users to add a new customer, retrieve an existing customer, update a customer and delete a customer from the database.
The app uses an in-memory H2 database for storing customer information. When the app starts, it default inserts few dummy customers in the database.

#2) How to run the app
After cloning the app in your local repository, run the below class as a Java application

src/main/java/com.example.springboot.DemoApplication

This will start the application on port 8090. The port name can be configured in application.properties file under src/main/resources

#3) REST API
Once the app is up and running, please use the below REST API end points

a) http://localhost:8090/customers - GET call to retrieve all current customers from db
b) http://localhost:8090/customers/{id} - GET call to retrieve a specific customer based on its customer id e.g. http://localhost:8090/customers/1 will give below json output

{"id":1,"name":"quae","address":"Rerum temporibus dolores dolore dolores."}

c) http://localhost:8090/customers?name=quae - GET call to retrieve a specific customer based on customer name e.g.

http://localhost:8090/customers?name=quae will give below json output

[{"id":1,"name":"quae","address":"Rerum temporibus dolores dolore dolores."}]

d) http://localhost:8090/customers - POST call to add a new customer. Customer information to be specifiec in below json format e.g.

{"name":"Sam","address":"USA"}

This will add a new customer "Sam" to the database and provide customer information along with Customer Id as output e.g.
{
  "id": 21,
  "name": "Sam",
  "address": "USA"
}

e) http://localhost:8090/customers/1 - DELETE call to delete a particular customer based on customer id.


