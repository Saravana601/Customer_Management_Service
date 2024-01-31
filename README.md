# Customer Management System

This project is a Customer Management System built with Spring Boot and Java. It includes features for managing customers, user authentication, and authorization.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Authentication](#authentication)

## Features

- Create, read, update, and delete customers.
- User authentication and authorization.
- Token-based authentication with JSON Web Tokens (JWT).

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- MySQL database

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/customer-management-system.git

## Usage

After successfully running the application, you can access the API endpoints and perform CRUD operations on customers. Additionally, the project includes authentication endpoints for user registration and login.

## Endpoints

- **Create a customer:** `POST /api/v1/customers`
- **Get all customers:** `GET /api/v1/customers`
- **Get a single customer by ID:** `GET /api/v1/customers/{id}`
- **Update a customer:** `PUT /api/v1/customers/{id}`
- **Delete a customer:** `DELETE /api/v1/customers/{id}`
- **User registration:** `POST /api/v1/auth/register`
- **User authentication:** `POST /api/v1/auth/authenticate`

## Authentication

The project uses JWT for token-based authentication. To authenticate, send a POST request to `/api/v1/auth/authenticate` with the user's credentials. The response will contain a JWT token, which should be included in the Authorization header for subsequent requests.

## Contact

If you have any questions or suggestions, feel free to contact me at the following
- [Gmail](saravanad2401@gmail.com).
- [LinkedIn](https://www.linkedin.com/in/saravanad2401/).
