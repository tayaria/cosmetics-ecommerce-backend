# Cosmetics E-Commerce Backend API

A robust Spring Boot backend application for managing a cosmetics e-commerce platform with comprehensive features for product management, order processing, user authentication, and administration.

## Technology Stack

- **Java**: 17
- **Framework**: Spring Boot 3.x
- **Build Tool**: Maven
- **Database**: MySQL / PostgreSQL
- **Security**: Spring Security with JWT
- **Documentation**: Swagger/OpenAPI
- **Email**: JavaMailSender
- **Payment Integration**: Stripe/PayPal (as applicable)

## Features

### User Management
- User registration and authentication
- JWT-based authorization
- Role-based access control (ADMIN, USER)
- Password encryption with BCrypt
- Email verification
- Password reset functionality

### Product Management
- CRUD operations for products
- Category and subcategory management
- Product image upload and management
- Stock management
- Product search and filtering
- Product reviews and ratings

### Order Management
- Shopping cart functionality
- Order creation and tracking
- Order status management
- Order history
- Invoice generation

### Payment Processing
- Secure payment gateway integration
- Multiple payment methods support
- Payment status tracking
- Transaction history

### Admin Features
- Dashboard statistics
- User management
- Product inventory management
- Order management and processing
- Sales reports and analytics

## Prerequisites

- JDK 17 or higher
- Maven 3.6+
- MySQL 8.0+ or PostgreSQL 12+
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## Installation

### 1. Clone the repository
```bash
git clone https://github.com/yourusername/cosmetics-backend.git
cd cosmetics-backend
```

### 2. Configure Database
Create a MySQL database:
```sql
CREATE DATABASE cosmetics_db;
```

Update `application.properties` or `application.yml`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/cosmetics_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Configure Application Properties
Update the following in `src/main/resources/application.properties`:

```properties
# Server Configuration
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/cosmetics_db
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT Configuration
jwt.secret=your-secret-key-here
jwt.expiration=86400000

# File Upload Configuration
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
file.upload-dir=./uploads

# Email Configuration
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# CORS Configuration
cors.allowed-origins=http://localhost:4200,http://localhost:4201
```

### 4. Build the project
```bash
mvn clean install
```

### 5. Run the application
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

## Project Structure

```
cosmetics-backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cosmetics/
│   │   │           ├── config/
│   │   │           │   ├── SecurityConfig.java
│   │   │           │   ├── CorsConfig.java
│   │   │           │   └── SwaggerConfig.java
│   │   │           ├── controller/
│   │   │           │   ├── AuthController.java
│   │   │           │   ├── ProductController.java
│   │   │           │   ├── OrderController.java
│   │   │           │   ├── CategoryController.java
│   │   │           │   └── UserController.java
│   │   │           ├── model/
│   │   │           │   ├── User.java
│   │   │           │   ├── Product.java
│   │   │           │   ├── Order.java
│   │   │           │   ├── Category.java
│   │   │           │   └── OrderItem.java
│   │   │           ├── dto/
│   │   │           │   ├── LoginRequest.java
│   │   │           │   ├── RegisterRequest.java
│   │   │           │   ├── ProductDTO.java
│   │   │           │   └── OrderDTO.java
│   │   │           ├── repository/
│   │   │           │   ├── UserRepository.java
│   │   │           │   ├── ProductRepository.java
│   │   │           │   ├── OrderRepository.java
│   │   │           │   └── CategoryRepository.java
│   │   │           ├── service/
│   │   │           │   ├── UserService.java
│   │   │           │   ├── ProductService.java
│   │   │           │   ├── OrderService.java
│   │   │           │   ├── AuthService.java
│   │   │           │   └── EmailService.java
│   │   │           ├── security/
│   │   │           │   ├── JwtTokenProvider.java
│   │   │           │   ├── JwtAuthenticationFilter.java
│   │   │           │   └── UserDetailsServiceImpl.java
│   │   │           ├── exception/
│   │   │           │   ├── GlobalExceptionHandler.java
│   │   │           │   ├── ResourceNotFoundException.java
│   │   │           │   └── UnauthorizedException.java
│   │   │           └── util/
│   │   │               └── FileUploadUtil.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-dev.properties
│   └── test/
│       └── java/
├── uploads/
├── pom.xml
└── README.md
```

## API Endpoints

### Authentication
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - User login
- `POST /api/auth/refresh` - Refresh JWT token
- `POST /api/auth/forgot-password` - Request password reset
- `POST /api/auth/reset-password` - Reset password

### Products
- `GET /api/products` - Get all products (with pagination and filters)
- `GET /api/products/{id}` - Get product by ID
- `POST /api/products` - Create new product (Admin only)
- `PUT /api/products/{id}` - Update product (Admin only)
- `DELETE /api/products/{id}` - Delete product (Admin only)
- `GET /api/products/search` - Search products
- `GET /api/products/category/{categoryId}` - Get products by category

### Categories
- `GET /api/categories` - Get all categories
- `GET /api/categories/{id}` - Get category by ID
- `POST /api/categories` - Create category (Admin only)
- `PUT /api/categories/{id}` - Update category (Admin only)
- `DELETE /api/categories/{id}` - Delete category (Admin only)

### Orders
- `GET /api/orders` - Get all orders (Admin) or user orders
- `GET /api/orders/{id}` - Get order by ID
- `POST /api/orders` - Create new order
- `PUT /api/orders/{id}/status` - Update order status (Admin only)
- `DELETE /api/orders/{id}` - Cancel order

### Users (Admin only)
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user
- `GET /api/users/{id}/orders` - Get user orders

### Cart
- `GET /api/cart` - Get user cart
- `POST /api/cart/items` - Add item to cart
- `PUT /api/cart/items/{id}` - Update cart item
- `DELETE /api/cart/items/{id}` - Remove cart item
- `DELETE /api/cart` - Clear cart

## API Documentation

Once the application is running, access Swagger UI at:
```
http://localhost:8080/swagger-ui.html
```

## Security

- JWT tokens for authentication
- BCrypt password hashing
- CORS configuration for frontend integration
- Role-based access control
- Request validation and sanitization

## Testing

Run unit tests:
```bash
mvn test
```

Run integration tests:
```bash
mvn verify
```

## Database Schema

Key entities:
- **User**: id, username, email, password, role, created_at
- **Product**: id, name, description, price, stock, category_id, image_url, created_at
- **Category**: id, name, description
- **Order**: id, user_id, total_amount, status, order_date
- **OrderItem**: id, order_id, product_id, quantity, price
- **Cart**: id, user_id, created_at
- **CartItem**: id, cart_id, product_id, quantity

## Environment Variables

Create a `.env` file or set environment variables:
```
DB_HOST=localhost
DB_PORT=3306
DB_NAME=cosmetics_db
DB_USER=root
DB_PASSWORD=password
JWT_SECRET=your-jwt-secret
MAIL_USERNAME=your-email@gmail.com
MAIL_PASSWORD=your-app-password
```

## Deployment

### Docker
```dockerfile
FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

Build and run:
```bash
docker build -t cosmetics-backend .
docker run -p 8080:8080 cosmetics-backend
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License.

## Contact

Aymen Tayari - aymentayari191@gmail.com

Project Link: [https://github.com/yourusername/cosmetics-backend](https://github.com/yourusername/cosmetics-backend)](https://github.com/tayaria/cosmetics-ecommerce-backend)

## Acknowledgments

- Spring Boot Documentation
- Spring Security
- JWT.io
- Swagger/OpenAPI
