# SpringMVCDemo

**SpringMVCDemo** is a sample web application built using Java and the Spring Framework.

This project was originally developed as part of a **job application task in 2020**, designed to demonstrate practical knowledge of Spring Boot, Spring Security, Spring Session, MVC architecture, and Thymeleaf view rendering.

---

## 🚀 Overview

This is a basic yet functional **Spring MVC web application** that includes:

- User login and permission handling  
- Security layer powered by **Spring Security**  
- Session support via **Spring Session**  
- Controllers managed by **Spring Boot**  
- Server-rendered views using **Thymeleaf** templates

The application uses a **MySQL database** for persistence and supports simple user role scenarios.

---

## 🎯 Key Features

- **Secure login** with user roles  
- **Permission handling** across views  
- **Session support**  
- **Simple MVC structure**  
- Starter implementation ready for enhancement

> This is a demonstration-level application suitable for learning and extension, rather than a production-ready system.

---

## 📦 Requirements

To run this project, you need:

- Java Runtime Environment (JRE) installed  
- A MySQL database

The default database name is: `springdemo`

You can modify database settings in `application.properties`.

The database schema creation query can be found in: `src/main/resources/schema.sql`

---

## 🛠 Installation

1. Clone the repository  
2. Build the project (e.g., via Maven)  
3. Package it into a `.jar` file  
4. Run the application:

```bash
java -jar demo-application.jar
```

To override configuration settings on startup, place an external application.properties beside the .jar — this will override defaults.

---
## ▶️ First Run

On first startup with an empty database, the application will:

- Create the necessary schema  
- Insert initial test data automatically  

No additional manual setup is required for initial execution.

---


## 🔁 Subsequent Runs

By default, Spring Boot may attempt to reinitialize the database on each startup.

To prevent re-insertion of test data (which may result in unique constraint violations), adjust the following property:

```properties
spring.datasource.initialization-mode=never
```

Alternatively, configure the appropriate SQL initialization strategy depending on your Spring Boot version.

---

## 🧪 Test Data

The application provides predefined users for demonstration and testing purposes:

| Username | Password | Roles        |
|----------|----------|--------------|
| Admin    | Admin    | ADMIN        |
| User 1   | User 1   | EDITOR, USER |
| User 2   | User 2   | EDITOR       |
| User 3   | User 3   | USER         |

These accounts allow verification of role-based access control and permission handling.

---

## 📌 Context

This project was originally created in 2020 as part of a job application assignment.  

The objective was to demonstrate:

- Practical understanding of Spring Boot  
- MVC architectural patterns  
- Authentication and authorization using Spring Security  
- Session handling  
- Database integration with JPA  

The repository is preserved as a reference implementation and portfolio artifact.

---

## 📜 License

This project is licensed under the MIT License. See the `LICENSE` file for details.