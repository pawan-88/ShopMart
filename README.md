
# ShopMart Project README

## Overview
ShopMart is a web application developed using Spring Boot, a powerful and versatile framework for building Java-based enterprise applications. This project focuses on providing RESTful APIs for managing categories and products in an online shopping system.

## Technologies Used
* **Spring Boot:** The core framework for building the application.
* **Spring Data JPA and Hibernate:** For seamless interaction with the relational database.
* **REST Controllers:** Handling HTTP requests and responses in a RESTful manner.
* **Relational Database (RDB):** Storing and managing data persistently.
* **Server-Side Pagination:** Enhancing performance by retrieving data in chunks.
* **Annotation-based Configuration:** Simplifying the configuration process without the need for XML files.
 
## Database Configuration
 Ensure that you have a relational database set up, and configure the database connection details in the application.properties file.

## **Database Configuration**
* **spring.datasource.url**=jdbc:mysql://localhost:3306/shopmart
* **spring.datasource.username**=root
* **spring.datasource.password**=root
* **spring.datasource.driver-class-name**=com.mysql.cj.jdbc.Driver
* **spring.jpa.show-sql**=true
* **spring.jpa.hibernate.ddl-auto**=update

## Category CRUD Operations
##### 1. Get all categories
GET http://localhost:8080/api/categories?page=3
##### 2. Create a new category
POST http://localhost:8080/api/categories
##### 3. Get category by Id
GET http://localhost:8080/api/categories/{id}
##### 4. Update category by Id
PUT http://localhost:8080/api/categories/{id}
##### 5. Delete category by Id
DELETE http://localhost:8080/api/categories/{id}
## Product CRUD Operations
##### 1. Get all products
GET http://localhost:8080/api/products?page=2
##### 2. Create a new product
POST http://localhost:8080/api/products
##### 3. Get product by Id
GET http://localhost:8080/api/products/{id}
##### 4. Update product by Id
PUT http://localhost:8080/api/products/{id}
##### 5. Delete product by Id
DELETE http://localhost:8080/api/products/{id}
## Relation between Category and Products
There is a one-to-many relationship between categories and products, where one category can have multiple products.

## Server-Side Pagination
Machine tests are designed with server-side pagination to optimize data retrieval and improve overall application performance.

## Fetching Single Product Details
When fetching details of a single product, the response will include information about the respective category to provide comprehensive details.

## Build and Run
1. Clone the repository.
2. Ensure your database is set up and configured.
3. Build and run the application using your preferred IDE or command line:
bash
**./mvnw spring-boot:run**
4. Access the APIs using the provided endpoints.
