# Arka Market API 🛒

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.2-brightgreen?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-18.2-blue?style=for-the-badge&logo=postgresql)

A RESTful API for a market application, built with **Java** and the **Spring Boot** framework.

---

## 📋 Table of Contents
- [About The Project](#-about-the-project)
- [Built With](#-built-with)
- [Getting Started](#-getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#-usage)
- [API Documentation](#-api-documentation)
- [Configuration](#-configuration)

---

## 📖 About The Project

**Arka Market** is a backend service that provides a set of RESTful endpoints to manage market-related operations. This project serves as a practical example of building a robust and scalable API using modern Java technologies and clean architecture principles.

## 🛠️ Built With

This project is built using the following technologies and frameworks:

* **Java 21** (OpenJDK)
* **Spring Boot 4.0**
* **Gradle** (Build Tool)
* **Spring Data JPA** (Hibernate 7.x)
* **PostgreSQL** (Database)
* **SpringDoc OpenAPI** (Swagger UI)

## 🚀 Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites
Make sure you have the following software installed on your machine:
* **JDK 21** or later.
* **Gradle** 8.x or higher.
* An IDE of your choice (e.g., **IntelliJ IDEA**, **VS Code**).
* A running instance of **PostgreSQL**.

### Installation

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/ArkaDevp/market-api
Navigate into the project directory:

Bash
cd arka-market
Build the project to download dependencies:

Bash
./gradlew clean build
💻 Usage
You can run the application using your IDE or directly from the command line:

Bash
./gradlew bootRun
The application will start on the default port 8080. You should see the Spring Boot banner and a "Started" message in the logs.

📑 API Documentation
This project uses SpringDoc to automatically generate API documentation in the OpenAPI 3.0 format. Once the application is running, you can access the interactive Swagger UI to explore and test the API endpoints.

Swagger UI: http://localhost:8080/swagger-ui.html

OpenAPI Spec (JSON): http://localhost:8080/v3/api-docs

⚙️ Configuration
The main configuration for the application is located in src/main/resources/application.properties (or application.yml).

Properties Example:
Properties
# Active Profile
spring.profiles.active=dev
spring.application.name=arka-market

# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/arka-market
spring.datasource.username=your_user
spring.datasource.password=your_password

# OpenAPI / Swagger
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.api-docs.path=/v3/api-docs
The application is configured to run with the dev profile by default. You can create different configuration files for different environments (e.g., application-prod.properties) and switch between them.
