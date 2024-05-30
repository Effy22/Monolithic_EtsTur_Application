Monolithic_EtsTur_Application

Overview

The Monolithic_EtsTur_Application is a Spring Boot project designed to emulate the functionality of the EtsTur application. This project leverages several robust technologies to ensure efficiency, scalability, and security.

Technologies Used

Spring Boot Starter Web: For building web applications, including RESTful services.
Spring Boot Starter Data MongoDB: For integrating MongoDB as the primary database.
Lombok: To reduce boilerplate code for model objects.
MapStruct: For generating type-safe and performant mappers.
SpringDoc OpenAPI: To generate API documentation and UI.
Java JWT: For handling JSON Web Tokens in authentication.
Spring Boot Starter Mail: For sending emails from the application.
Features

RESTful API: Provides endpoints for various functionalities of the EtsTur application.
MongoDB Integration: Utilizes MongoDB for data storage, ensuring flexibility and scalability.
JWT Authentication: Secures endpoints using JSON Web Tokens.
API Documentation: Automatically generates interactive API documentation using SpringDoc OpenAPI.
Email Service: Capable of sending emails using Spring Boot's Mail starter.
Setup

Clone the repository:

sh
Kodu kopyala
git clone <repository-url>
cd Monolithic_EtsTur_Application
Update application properties:
Configure the src/main/resources/application.properties file with your MongoDB connection details, mail server settings, and any other required configurations.

Build the project:

sh
Kodu kopyala
./mvnw clean install
Run the application:

sh
Kodu kopyala
./mvnw spring-boot:run
Access the application:

API Documentation: http://localhost:8080/swagger-ui.html
Application Endpoints: Check the API documentation for available endpoints.
Project Structure

src/main/java: Contains the main application code.
src/main/resources: Contains configuration files and static resources.
src/test: Contains test cases for the application.
Contribution

Feel free to submit issues, fork the repository, and send pull requests. Contributions are welcome and appreciated!

License

This project is licensed under the MIT License.


# MONGO DB
    Database Name: EtsTurDB
    Kullanıcı: tatiluser
    Şifre: tatiluser*
