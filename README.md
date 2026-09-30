STOREmate 🛒

STOREmate is a grocery-store management backend built with Spring
Boot and MySQL. It provides REST APIs for users, shopping carts,
orders, product categories, and an admin dashboard.

The project is designed as a backend for a grocery/e-commerce
application where users can browse products, manage their cart, and
place orders, while administrators can log in and monitor inventory and
store activity.

🚀 Features

User Features

User registration

User login

Browse grocery products by category

View products from:

Fruits

Vegetables

Beverages

Frozen items

Grains & Cereals

Snacks

Personal Care

Add products to cart

View cart

Update cart/product stock

Remove items from cart

Place orders

Admin Features

Admin login

Admin dashboard

Monitor store/order information

Check low-stock products

Check zero-stock products

View sales-related information

Note: Profit/loss calculation and a top-5-most-sold-products
feature are not part of the current version of STOREmate.

🛠️ Tech Stack

Technology          Purpose

Java 17             Programming language / project target
Spring Boot 3.4.4   Backend framework
Spring Web          REST API development
Spring Data JPA     Database interaction
MySQL               Relational database
Maven               Dependency management and build tool
REST API            Communication between frontend/client and backend

The project was also tested in an environment running Java 23, while the
project configuration targets Java 17.

📋 Prerequisites

Before running STOREmate, install:

Java JDK 17 or compatible newer JDK

Maven (if Maven Wrapper is not included)

MySQL Server

An IDE such as:

IntelliJ IDEA

Eclipse

Spring Tool Suite

VS Code

No XAMPP installation is required if MySQL Server is installed
separately.

📥 Clone the Repository

Replace the repository URL with your actual GitHub repository URL:

git clone <YOUR_GITHUB_REPO_URL>
cd STOREmate

If the repository uses a different folder name, enter that folder
instead.

🗄️ Database Setup

Create the MySQL database:

CREATE DATABASE storemate;

Then configure the database connection in:

src/main/resources/application.properties

Example:

spring.datasource.url=jdbc:mysql://localhost:3306/storemate
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Replace YOUR_MYSQL_PASSWORD with your MySQL password.

If your local MySQL configuration uses a different username, port, or
password, update these values accordingly.

Security: Do not commit real database passwords, API keys, or
other secrets to GitHub. Use environment variables or a local
configuration file for sensitive values.

▶️ Run the Application

Using Maven

On Windows:

mvnw.cmd spring-boot:run

On Linux/macOS:

./mvnw spring-boot:run

If Maven is installed globally:

mvn spring-boot:run

The application will normally start at:

http://localhost:8080

🔗 API Base URL

http://localhost:8080

The endpoint paths below are based on the current STOREmate application
mappings.

📡 API Endpoints

👤 User APIs

Method   Endpoint                Description

POST     /api/v1/users/save    Register/save a user
POST     /api/v1/users/login   User login

Example

POST /api/v1/users/save

POST /api/v1/users/login

🛒 Cart APIs

Method   Endpoint                      Description

POST     /api/v1/cart/add            Add a product/item to the cart
GET      /api/v1/cart/view           View the current cart
PUT      /api/v1/cart/update-stock   Update stock/cart quantity
DELETE   /api/v1/cart/remove/{id}    Remove an item from the cart
POST     /api/v1/cart/place-order    Place an order using the cart

Cart Flow

Browse Products
      ↓
Add to Cart
      ↓
View Cart
      ↓
Update Quantity/Stock
      ↓
Place Order

🔐 Admin APIs

Method   Endpoint                  Description

POST     /admin/login            Admin login
GET      /page/admin/dashboard   Admin dashboard

🛍️ Product APIs

Method   Endpoint                  Category

GET      /beverages/all          Beverages
GET      /frozen/all             Frozen
GET      /fruits/all             Fruits
GET      /GrainsAndCereals/all   Grains & Cereals
GET      /personal/all           Personal Care
GET      /snacks/all             Snacks
GET      /vegetables/all         Vegetables

These endpoints return the available products/items for their respective
categories.

🧩 API Endpoint Summary

Module            Method   Endpoint

Admin             POST     /admin/login
Cart              POST     /api/v1/cart/add
Cart              POST     /api/v1/cart/place-order
Cart              DELETE   /api/v1/cart/remove/{id}
Cart              PUT      /api/v1/cart/update-stock
Cart              GET      /api/v1/cart/view
Users             POST     /api/v1/users/login
Users             POST     /api/v1/users/save
Products          GET      /beverages/all
Products          GET      /frozen/all
Products          GET      /fruits/all
Products          GET      /GrainsAndCereals/all
Admin Dashboard   GET      /page/admin/dashboard
Products          GET      /personal/all
Products          GET      /snacks/all
Products          GET      /vegetables/all

🏗️ Project Structure

A typical structure of the project is:

STOREmate/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── store/
│   │   │           └── mate/
│   │   │               └── STOREmate/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md

The exact package/class structure may vary depending on the current
source code.

🔄 Application Workflow

                    STOREmate
                        │
          ┌─────────────┴─────────────┐
          │                           │
        USER                         ADMIN
          │                           │
     Login/Register               Admin Login
          │                           │
    Browse Products             Admin Dashboard
          │                           │
      Add to Cart               Store Monitoring
          │
       View Cart
          │
    Update Quantity
          │
     Place Order

🗃️ Database

STOREmate uses MySQL as its relational database.

Database:

storemate

Spring Data JPA is used to communicate with the database and manage
persistent application data.

🧪 Testing the APIs

You can test the REST APIs using tools such as:

Postman

Insomnia

IntelliJ HTTP Client

Any frontend application

Example:

GET http://localhost:8080/fruits/all

For POST requests, provide the required JSON request body according to
the DTO/entity expected by the corresponding controller.

⚙️ Configuration

Important configuration is stored in:

src/main/resources/application.properties

Typical configuration includes:

spring.datasource.url=jdbc:mysql://localhost:3306/storemate
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.jpa.hibernate.ddl-auto=update

Do not upload production credentials to GitHub.

📌 Current Scope

STOREmate currently focuses on:

Grocery product browsing

User management

Cart management

Order placement

Stock management

Admin login

Admin dashboard

Inventory monitoring

Sales/order information

The following are intentionally outside the current scope:

Profit/loss calculation

Top-5 sold product analytics

👨‍💻 Development

To build the project without starting the application:

mvnw.cmd clean package

On Linux/macOS:

./mvnw clean package

To run the generated application JAR:

java -jar target/<generated-jar-name>.jar

🤝 Contributing

Fork the repository.

Create a new branch:

git checkout -b feature/your-feature

Make your changes.

Commit your changes:

git add .
git commit -m "Add your feature"

Push the branch:

git push origin feature/your-feature

Open a Pull Request.

👤 Author

Sameer Kumar

Project: STOREmate
Type: Grocery Store Management / E-commerce Backend
Backend: Spring Boot
Database: MySQL
