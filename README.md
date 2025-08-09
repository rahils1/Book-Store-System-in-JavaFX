# Sparky Book Service

A JavaFX-based desktop application for buying and selling used books with an integrated database management system.

## Overview

Sparky Book Service is a comprehensive marketplace application that allows users to register as buyers, sellers, or both. The platform facilitates book transactions with features including user authentication, book listings, shopping cart functionality, and automated pricing based on book condition.

## Features

### User Management
- **User Registration & Authentication**: Secure account creation and login system
- **Multi-role Support**: Users can register as Buyers, Sellers, or both
- **Account Management**: View and modify account information
- **Password Management**: Secure password change functionality

### Book Management
- **Advanced Search & Filtering**: Search books by title with filters for genre and condition
- **Book Listing**: Sellers can list books with automated pricing suggestions
- **Inventory Management**: Real-time book availability tracking
- **Genre Categories**: Support for multiple genres (Sci-Fi, Fantasy, Comedy, Drama, Thriller, Adventure, Mystery)

### Shopping Experience
- **Shopping Cart**: Add books to cart and manage selections
- **Order Processing**: Confirm purchases and update inventory
- **Dynamic Pricing**: Automated price calculation based on book condition with admin fee structure

### Condition-Based Pricing
- **Used Like New**: 10% admin fee
- **Moderately Used**: 8% admin fee  
- **Heavily Used**: 6% admin fee

## Technical Requirements

### Software Dependencies
- **Java Runtime**: Oracle OpenJDK 22.0.2 or compatible
- **JavaFX**: JavaFX SDK 22.0.2
- **Database**: MySQL Server 8.0 or higher
- **JDBC Driver**: MySQL Connector/J

## Installation & Setup

### 1. Database Configuration
```bash
# Import the database schema
mysql -u root -p < Backup.sql
```

### 2. Database Connection Setup
Update the MySQL password in `src/MySQLHandler.java`:
```java
private static final String PASSWORD = "your_mysql_root_password";
```

### 3. Dependencies
Ensure the MySQL Connector/J library is included in your project classpath:
- Download MySQL Connector/J from the official MySQL website
- Add the JAR file to your project's library path
- Verify the JDBC driver is accessible at runtime

### 4. JavaFX Setup
- Download JavaFX SDK 22.0.2
- Configure your IDE to include JavaFX modules
- Add JavaFX runtime arguments if necessary

## Project Structure

```
sparky-book-service/
├── src/
│   ├── PageHandler.java          # Main application entry point
│   ├── LoginPage.java           # User authentication interface
│   ├── RegisterPage.java        # User registration interface
│   ├── BookSearch.java          # Book browsing and search functionality
│   ├── SellerPage.java          # Book listing interface for sellers
│   ├── AccountOverview.java     # User account management
│   ├── cart.java                # Shopping cart functionality
│   ├── User.java                # User data model
│   ├── Book.java                # Book data model
│   ├── DataManipulator.java     # Database operations utility
│   ├── MySQLHandler.java        # Database connection management
│   └── PasswordChange.java      # Password modification interface
├── Backup.sql                   # Database schema and sample data
└── README.md                    # Project documentation
```

## Database Schema

### Users Table
- `username` (VARCHAR, Primary Key): Unique user identifier
- `fullName` (VARCHAR): User's full name
- `email` (VARCHAR): User's email address
- `pass` (VARCHAR): Encrypted password
- `userType` (VARCHAR): Account type (Buyer, Seller, Buyer and Seller)

### Books Table
- `id` (INT, Primary Key, Auto Increment): Unique book identifier
- `title` (VARCHAR): Book title
- `genre` (VARCHAR): Book genre category
- `bookCondition` (VARCHAR): Physical condition of the book
- `seller` (VARCHAR): Username of the seller
- `price` (DOUBLE): Listed price
- `sold` (BOOLEAN): Sale status

## Usage

### For Buyers
1. Register an account or log in
2. Browse available books using search and filters
3. Add desired books to shopping cart
4. Review cart and confirm orders

### For Sellers
1. Register as a seller or dual-role account
2. Navigate to the seller interface
3. Enter book details (title, genre, condition)
4. Use price generation tool for optimal pricing
5. List books for sale

### For Administrators
- Monitor transactions through database
- Manage user accounts and book listings
- Track commission revenue from sales

## Development

### Building for Distribution
1. Ensure all dependencies are properly configured
2. Package the application with JavaFX runtime
3. Include MySQL Connector/J in the distribution
4. Provide database setup instructions for end users

## Security Considerations

- **Database Security**: Ensure MySQL server is properly secured
- **Password Management**: Consider implementing password hashing
- **Input Validation**: Application includes basic input sanitization
- **SQL Injection**: Uses parameterized queries where applicable

## Troubleshooting

### Common Issues
- **Database Connection Failure**: Verify MySQL service is running and credentials are correct
- **JavaFX Runtime Error**: Ensure JavaFX modules are properly configured
- **Missing Dependencies**: Verify all required JAR files are in classpath

### Support
For technical issues or feature requests, please refer to the project documentation or contact the development team.

---

**Version**: 1.0  
**Last Updated**: November 2024  
**Developed with**: Java 22, JavaFX 22.0.2, MySQL 8.0
