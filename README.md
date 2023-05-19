# Real Estate Relational Database Listing App Documentation

## Authors: Cameron, DaJon, Stephen, Andrew & Chris

## Description
This Real Estate Listing app is a web-based application that enables users to browse and search through real estate listings. It is built using Spring Boot and Thymeleaf and utilizes Bootstrap for the front-end design.

## Features
1. **User Authentication**: Users are able to log in and log out of the app. User authentication is handled securely.

2. **Browse Listings**: Users can browse through all listings available on the platform.

3. **Search Listings**: Users can search for listings by city.

4. **Listing Details**: Each listing has a detailed view, showing more information about the property.

5. **Agent Information**: Information about real estate agents can be accessed through the agents page.

## Development Process

### Front-end
The front-end of the application was developed using Thymeleaf and Bootstrap. Thymeleaf is a server-side Java template engine for web applications. It's a fully HTML5-compatible.

Bootstrap, a powerful front-end framework, was used to speed up the development process and create responsive and visually appealing pages.

### Back-end
The back-end was developed using Spring Boot, a framework that makes it easy to create stand-alone, production-grade Spring-based applications. Spring Boot automatically configures your Spring application based on the jar dependencies you added in the project.

### Database
JPA (Java Persistence API) along with Hibernate was used to interact with the database. JpaRepository, a JPA specific extension of Repository, was used for the CRUD operations on the entities.

## How to Run the Application

1. **Clone the repository**: Clone the repository to your local machine using the command `git clone [https://github.com/QuantumSort/RelationalDatabase.git]`.

2. **Import the project**: Import the project into your preferred IDE. This project uses a Gradle build, so be sure to import it as a Gradle project.

3. **Set up the database**: Set up your preferred database and configure the application properties to point to your database.

4. **Run the application**: You can run the application from your IDE by running the main class, or you can use the command `./gradlew bootRun` from the terminal in the project directory.

5. **Access the application**: Access the application in your web browser at `http://localhost:8080`.

## Contribution Guidelines
We welcome contributions to this project. Please follow these guidelines:
- Fork the repository
- Create a new branch for your feature
- Write clean, well-documented code
- Submit a pull request, detailing the changes you made and why
- Await review and possible merge of your code

## Troubleshooting
If you encounter any issues while setting up or running the project, please first check the [Spring Boot documentation](https://spring.io/projects/spring-boot) and [Thymeleaf documentation](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html). If you can't find a solution, feel free to open an issue on this repository detailing the problem.

## Contact
For any inquiries, reach out to [CodrCam](https://github.com/CodrCam) or any of the project contributors.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Wireframing

[Wireframes](./wireframes)

## Database Schema

![schema](./images/schema.png)

![schema1](./images/image.png)


## Domain Modeling

![schema2](./images/Domain_Framework.png)


## References

Clean Code: A Handbook of Agile Software Craftsmanship - Robert C. Martin

Stack Overflow for the mapping issues

OpenAI Chat GPT for some documentation formatting and troubleshooting errors.

[Spring Boot documentation](https://spring.io/projects/spring-boot)

