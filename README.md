# Bakery

A backend application for managing a bakery business — employees, customers,
product inventory, and order history.

## Status
🚧 Work in progress — actively developing following the suggested build order
(see Roadmap below).

## Features

- **Employee management** — each employee has a name, surname, and employment
  start date; one employee is designated as the bakery owner
- **Customer management** — full CRUD (create, read, update, delete) for
  customer data, including geographic address (latitude/longitude)
- **Product sales & inventory** — employees can sell products to customers
  (reducing stock), edit products (e.g. add toppings), and restock inventory
  from wholesale deliveries
- **Order history** — the bakery keeps a persistent record of past orders
- **Shortest path calculation** — finds the shortest route between the bakery
  and a given customer, so the owner can deliver fresh bread each morning

## Tech stack

- Java 25
- Spring Boot 4.0.3
- Gradle
- Spring Data JPA
- PostgreSQL (with DBViewer)
- Lombok
- JUnit 5
- Docker
- [springboot4-dotenv](https://github.com/paulschwarz/spring-dotenv) — loads environment variables from `.env`
- Graph algorithms (for shortest-path delivery routing)

## How to run

1. Clone the repository:
```bash
   git clone git@github.com:zagola/Bakery.git
   cd Bakery
```

2. Build the project:
```bash
   ./gradlew clean build
```

3. Start the database with Docker Compose:
```bash
   docker-compose up -d
```

4. Run the application:
```bash
   ./gradlew bootRun
```

The application will be available at `http://localhost:8083`.

## Roadmap

- [x] Repository setup
- [x] Class structure design & implementation
- [x] CRUD via console
- [x] Database structure & configuration
- [ ] Shortest-path delivery logic
- [ ] REST endpoints
- [ ] Deployment