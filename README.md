# Blog-Application
## Overview

  Blog Application is a SpringBoot Application designed to enable the users to create, comment and categorize posts based on topics, facilitating interactive discussions and well organized content.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Schema](#schema)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Configuration](#configuration)
- [Contact](#contact)

## Introduction

Blog Application is a blogging application to create blogs, posts and commenting on the particular post. This project leverages Spring Boot to provide a backend infrastructure with MySQL as the database. 

## Features

- Creating Posts and commenting on Posts 
- Categorizing posts according to the topics
- SignIn and SignUp as the user

## Schema




## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 17 or higher
- Maven
- MySQL or your preferred database

## Installation

1. Clone the repository:

   ```bash
     git clone https://github.com/SujiV-repo/Simple-Blog-Application.git

2. Navigate to the project directory:

   ```bash
   cd Simple-Blog-Application

3. Build the Project

   ```bash
   mvn clean install

## Usage

1. Running the application locally using the following command:

   ```bash
   mvn spring-boot:run

2. Visit 'http://localhost:8080' along with the API endpoint in you browser to access the Application.

## API Documentation

### Base URL

      http://localhost:8080/api-endpoint

### Authentication
  The API endpoints require JWT for authentication, include the JWT token in the Authorization Header as 'Bearer token' for secured endpoints.

### Swagger UI
  Access the Swagger UI for the interactive API documentation:

      http://localhost:8080/swagger-ui.html

### End Points

  ### Posts

  **Creating Posts**
  * **Endpoint:** 'POST/api/posts'
  * **Description:** Creating a new blog post
  * **Request Body:**
    
    ```bash
          
          
  * **Response:**
    
    ```bash

  **Get All Posts**
  * **Endpoint:** ''
  * **Description:** 
  * **Request Body:**
    
    ```bash
          
          
  * **Response:**
    
    ```bash

  
  **Get Post By Id**
  * **Endpoint:** ''
  * **Description:** 
  * **Request Body:**
    
    ```bash
          
          
  * **Response:**
    
    ```bash
    
## Configuration
### Application Properties

The main configuration for the Splitwise project is stored in the `src/main/resources/application.properties` file. 
Below are key configurations that you may want to customize:

  **Database Configuration**
  
    spring.datasource.url=jdbc:mysql://localhost:3306/myblog
    spring.datasource.username=root
    spring.datasource.password=root

  **Hibernate Configuration**
  
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
    spring.jpa.hibernate.ddl-auto=create
    spring.jpa.properties.hibernate.show_sql=true

  **Additional Hibernate Configuration**
      
      spring.jpa.show-sql=true


## Contact

If you have any questions, concerns, or suggestions, feel free to contact.

- **Email:** [veturisujith1999@gmail.com](mailto:veturisujith1999@gmail.com)
- **Issue Tracker:** [GitHub Issues](https://github.com/SujiV-repo/Simple-Blog-Application/issues)
