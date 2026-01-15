# 🛒 Cosmetics E-Commerce Backend

This project is the **backend of a cosmetics e-commerce web application**, developed using **Spring Boot**.  
It provides secure REST APIs to manage users, authentication, cosmetic products, categories, orders, and shopping carts.

---

## 📖 Project Overview

The backend is responsible for:
- Business logic
- User authentication and authorization
- Product and order management
- Communication with the database
- Providing RESTful APIs consumed by the Angular frontend

---

## 🚀 Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Hibernate
- MySQL
- Maven
- RESTful APIs
- JWT (JSON Web Token)

---

## ✨ Features
- User management (Admin / Customer)
- Secure authentication and authorization using JWT
- CRUD operations for cosmetic products
- Category management
- Order management
- Shopping cart management
- Contact and reservation management
- Secure and scalable REST API

---

## 🗂️ Project Architecture
The project follows a layered architecture:

- **Controller**: Handles HTTP requests and REST endpoints
- **Service**: Contains business logic
- **Repository**: Handles database operations
- **Entity**: JPA entities mapped to database tables
- **DTO**: Data Transfer Objects for clean data exchange

---

## ⚙️ Configuration

### 1️⃣ Database Configuration
Create a MySQL database:

```sql
CREATE DATABASE cosmetics_db;
