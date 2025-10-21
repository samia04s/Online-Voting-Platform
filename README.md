
# Online Voting Platform (Spring Boot)

A secure and extensible online voting backend built with Spring Boot, JWT, and MySQL. Features include user registration, login, role-based polling, voting, and email notification support.

## Features

- User registration and login
- JWT-secured authentication & role-based access
- Creating and managing polls and candidates
- Voting functionality with duplicate vote prevention
- Email notifications (configurable via environment)
- RESTful endpoints for easy frontend integration

## Tech Stack

- Java 24 / Spring Boot 3
- Spring Security, JPA (Hibernate)
- MySQL
- JWT Authentication
- Email via SMTP (Gmail supported)
- Maven

## Getting Started

### 1. Clone the Repository
git clone https://github.com/YOUR-USERNAME/Online-Voting-Platform.git
cd Online-Voting-Platform


### 2. Configure Environment Variables

Create a `.env` file in the project root  with:

DB_URL=jdbc:mysql://localhost:3306/voting_db?
useSSL=false&serverTimezone=UTC
DB_USERNAME=your_db_user
DB_PASSWORD=your_db_password
JWT_SECRET=your_jwt_secret_here
JWT_EXPIRATION_MS=3600000
MAIL_USERNAME=your_gmail@gmail.com
MAIL_PASSWORD=your_gmail_app_password

### 3. Setup Database

Start your MySQL server and create the database:
CREATE DATABASE voting_db;


### 4. Build & Run the Backend

### 5. API Usage

Use tools like Postman or a frontend to call:

- `POST /api/auth/register` – register a user
- `POST /api/auth/login` – login and get JWT
- `GET /api/polls` – list all polls
- `POST /api/votes` – vote for a candidate
- ...and others as defined in controllers

## Security

- Sensitive configuration is stored in `.env` and loaded at runtime (never commit secrets).
- Backend only—no built-in UI. Pair with your own frontend client.

## License

This project is open source and available under the [MIT License](LICENSE).

---

**Contributions welcome! Please open issues or pull requests for features and improvements.**




