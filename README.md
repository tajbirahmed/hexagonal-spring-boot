# Hexagonal Architecture Spring Boot Project

## Table of Contents
- [Project Overview](#project-overview)
- [Project Structure](#project-structure)
- [Features](#features)
- [How to Build](#how-to-build)
- [How to Run (Locally)](#how-to-run-locally)
- [How to Run with Docker](#how-to-run-with-docker)
- [How to Run with Docker Compose](#how-to-run-with-docker-compose)
- [API Documentation (Swagger/OpenAPI)](#api-documentation-swaggeropenapi)
- [Database Configuration](#database-configuration)
- [Troubleshooting](#troubleshooting)
- [References](#references)

---

## Project Overview
This project is a template for building Spring Boot applications using the Hexagonal (Ports and Adapters) architecture. It demonstrates clean separation of concerns, testability, and flexibility for integrating with different input/output mechanisms (REST, Kafka, JPA, etc).

---

## Project Structure

```
hexagonal/
├── Dockerfile
├── docker-compose.yml
├── create_schema.sql
├── pom.xml
├── mvnw, mvnw.cmd
├── src/
│   ├── main/
│   │   ├── java/com/hexagonal/
│   │   │   ├── HexagonalApplication.java
│   │   │   ├── adapter/
│   │   │   │   ├── input/
│   │   │   │   │   ├── kafka/
│   │   │   │   │   └── rest/
│   │   │   │   │       └── OrderController.java
│   │   │   │   └── output/
│   │   │   │       ├── JpaOrderRepository.java
│   │   │   │       ├── entity/OrderEntity.java
│   │   │   │       ├── mapper/OrderMapper.java
│   │   │   │       └── repository/SpringDataRepository.java
│   │   │   ├── config/OrderConfig.java
│   │   │   └── domain/
│   │   │       ├── dto/request/PlaceOrderRequest.java, TrackOrderRequest.java
│   │   │       ├── dto/response/TrackOrderResponse.java
│   │   │       ├── port/input/PlaceOrderUseCase.java, TrackOrderUseCase.java
│   │   │       ├── port/output/OrderRepositoryPort.java
│   │   │       └── service/OrderService.java
│   │   └── resources/application.yml
│   └── test/java/com/hexagonal/HexagonalApplicationTests.java
└── ...
```

### Key Folders
- **adapter/input**: Entry points (REST, Kafka, etc)
- **adapter/output**: Output adapters (JPA, mappers, repositories)
- **domain**: Business logic, DTOs, ports, and services
- **config**: Spring configuration classes
- **resources**: Application configuration (YAML)

---

## Features
- Hexagonal architecture (Ports & Adapters)
- Spring Boot 3.x
- Reactive stack (WebFlux)
- PostgreSQL integration
- MapStruct for mapping
- OpenAPI/Swagger UI documentation (springdoc-openapi)
- Docker & Docker Compose support

---

## How to Build

### Prerequisites
- Java 21+
- Maven 3.8+
- Docker (for containerization)

### Build with Maven
```sh
./mvnw clean package
```
The built JAR will be in `target/`.

---

## How to Run (Locally)

### 1. Start PostgreSQL (locally or with Docker)
- You can use the provided `create_schema.sql` for schema initialization.
- Default DB config (see `application.yml`):
  - Host: `localhost`
  - Port: `5432`
  - DB: `hexagonal_db`
  - User: `postgres`
  - Password: `postgres`

### 2. Run the Application
```sh
./mvnw spring-boot:run
```
Or run the built JAR:
```sh
java -jar target/*.jar
```

---

## How to Run with Docker

### 1. Build Docker Image
```sh
docker build -t hexagonal-app .
```

### 2. Run with Docker (standalone)
```sh
docker run -e DB_HOST=<db_host> -p 8080:8080 hexagonal-app
```
- Replace `<db_host>` with your Postgres host (e.g., `host.docker.internal` for local DB, or a Docker Compose service name).

---

## How to Run with Docker Compose

### 1. Start Both App and DB
```sh
docker-compose up --build
```
- This will start both the Postgres and application containers.
- The app will connect to the DB using the service name `postgres` and port `5432` (internal Docker network).

### 2. Stopping
```sh
docker-compose down
```

---

## API Documentation (Swagger/OpenAPI)

- **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **OpenAPI JSON**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

The project uses `springdoc-openapi-starter-webflux-ui` for automatic OpenAPI documentation generation.

---

## Database Configuration

- The application uses environment variable `DB_HOST` to determine the database host.
- In Docker Compose, this is set to the service name `postgres`.
- The default port is `5432` (internal Docker network).
- The schema is initialized using `create_schema.sql`.

---

## Troubleshooting

- **Connection Refused to DB**: Ensure the app uses `DB_HOST=postgres` and port `5432` when running in Docker Compose. Do not use `localhost` or the host-mapped port.
- **Swagger UI Not Accessible**: Make sure you are using the `springdoc-openapi-starter-webflux-ui` dependency for WebFlux projects.
- **App Starts Before DB**: Docker Compose uses `depends_on` and healthchecks to ensure the DB is ready before the app starts.
- **Port Conflicts**: Ensure no other service is using ports `5432` (Postgres) or `8080` (app) on your host.

---

## References
- [Hexagonal Architecture](https://alistair.cockburn.us/hexagonal-architecture/)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring WebFlux](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html)
- [springdoc-openapi](https://springdoc.org/)
- [Docker Compose](https://docs.docker.com/compose/)

---

## Video Walkthrough
- [Project Walkthrough Video](https://youtu.be/aMcmKVRk-Sk?si=uucqzY_ukf6jlvMu)

---

## Author
- Tajbir

---

