# 📚 Library Management System (Full-Stack)

A lightweight, full-stack Library Management System built to demonstrate core enterprise architecture patterns, RESTful API design, and database state management. 

This project bridges a custom Java Spring Boot backend with a dynamic, vanilla JavaScript frontend, handling real-time data persistence and cross-origin resource sharing (CORS).

## 🚀 Tech Stack

**Backend Engine:**
*   **Java 17+**
*   **Spring Boot 3** (Web, Data JPA)
*   **Maven** (Dependency Management)

**Database Layer:**
*   **H2 Database** (In-Memory Relational Database)
*   **Hibernate / ORM** (Automated SQL generation)

**Frontend UI:**
*   **HTML5 / CSS3** (Responsive dashboard design)
*   **Vanilla JavaScript** (Fetch API for asynchronous network requests)

## 🏗️ Architecture & Design Patterns

This application strictly adheres to the **Controller-Service-Repository** design pattern to ensure clean separation of concerns:
1.  **Controllers (REST API):** Handle incoming HTTP requests, route data, and manage CORS policies.
2.  **Services (Business Logic):** Execute "Guard Clauses" to validate borrowing rules before altering database states.
3.  **Repositories (Data Access):** Interface with Spring Data JPA to perform CRUD operations without boilerplate SQL.
4.  **Models (Entities/DTOs):** Define relational database tables (`@ManyToOne` relationships) and Data Transfer Objects for JSON parsing.

## ✨ Core Features

*   **View Catalog:** Fetches and displays all available and borrowed books dynamically.
*   **Add Users & Books:** REST endpoints configured to accept JSON payloads for creating new database entities.
*   **Borrowing Logic:** Validates book availability and user existence before processing a transaction.
*   **State Tracking:** Automatically generates timestamped `BorrowRecord` entries and updates real-time book availability statuses.

## 🔌 API Endpoints

| HTTP Method | Endpoint | Description | JSON Payload Example |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/books` | Fetch all books | None |
| `POST` | `/api/books` | Add a new book | `{"title": "Clean Code", "author": "Robert C. Martin"}` |
| `GET` | `/api/users` | Fetch all users | None |
| `POST` | `/api/users` | Add a new user | `{"name": "Alice", "email": "alice@email.com"}` |
| `POST` | `/api/borrow` | Borrow a book | `{"bookId": 1, "userId": 1}` |

## 🛠️ How to Run Locally

### 1. Start the Backend Server
1. Ensure Java and Maven are installed.
2. Clone this repository.
3. Navigate to the root directory and run the application via your IDE or use the Maven wrapper:
   ```bash
   ./mvnw spring-boot:run
4. The server will initialize on http://localhost:8080.

### 2. Launch the Frontend
1. Open the library-frontend folder.
2. Double-click the index.html file to open it in your web browser.
3. Note: Ensure the backend is running first so the frontend can successfully fetch the data.

## 🔮 Future Improvements
1. Implement a PostgreSQL database for permanent data persistence.
2. Add a PUT endpoint to handle returning borrowed books.
3. Integrate Spring Security for user authentication and authorization.