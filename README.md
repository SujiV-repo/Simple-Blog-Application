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

      http://localhost:8080/swagger-ui/index.html#/

### End Points

  ### Category

  **Adding a Category**
  * **Endpoint:** 'POST/api/categories'
  * **Description:** Creating a new category to categorize posts based on the topic.
  * **Request Body:**
    
    ```bash
          {
            "id": 1,
            "name": "Science",
            "description": "Science Related Category"
          }

  * **Response:**
    
    ```bash
        {
          "id": 1,
          "name": "Science",
          "description": "Science Related Category"
        }

  **Get all Categories**
  * **Endpoint:** 'GET/api/categories'
  * **Description:** Getting all the categories that are present in the application.
  * **Response:**
    
    ```bash
        [
          {
            "id": 1,
            "name": "Science",
            "description": "Science Related Category"
          }
        ]

  **Updating a particular Category**
  * **Endpoint:** 'PUT/api/categories/{id}'
  * **Description:** Updating a category name or description based on the Id
  * **Request Body:**
    
    ```bash
          {
            "id": 1,
            "name": "Science And Maths",
            "description": "Science and Maths Related Category"
          }

  * **Response:**
    
    ```bash
          {
            "id": 1,
            "name": "Science And Maths",
            "description": "Science and Maths Related Category"
          }

  **Getting a particular Category**
  * **Endpoint:** 'GET/api/categories/{id}'
  * **Description:** Getting a particular category based on the id.
  * **Response:**
    
    ```bash
          {
            "id": 1,
            "name": "Science And Maths",
            "description": "Science and Maths Related Category"
          }

  **Deleting a particular Category**
  * **Endpoint:** 'DELETE/api/categories/{id}'
  * **Description:** Deleting a particular category based on the id.
  * **Response:**
    
    ```bash
          Category deleted successfully!
  
  ### Posts

  **Creating Posts**
  * **Endpoint:** 'POST/api/posts'
  * **Description:** Creating a new blog post.
  * **Request Body:**
    
    ```bash
          {
            "id": 1,
            "title": "Science Research",
            "description": "Scientific Research related post",
            "content": "The research based on the scientifical experiments conducted",
            "categoryId": 1
          }
          
  * **Response:**
    
    ```bash
            {
              "id": 1,
              "title": "Science Research",
              "description": "Scientific Research related post",
              "content": "The research based on the scientifical experiments conducted",
              "comments": null,
              "categoryId": 1
            }

  **Get All Posts**
  * **Endpoint:** 'GET/api/posts'
  * **Description:** Getting all the posts present.      
  * **Response:**
    
    ```bash
        {
          "content": [
            {
              "id": 1,
              "title": "Science Research",
              "description": "Scientific Research related post",
              "content": "The research based on the scientifical experiments conducted",
              "comments": [],
              "categoryId": 1
            }
          ],
        "pageNo": 0,
        "pageSize": 10,
        "totalElements": 1,
        "totalPages": 1,
        "last": true
      }
  
  **Get Post By Id**
  * **Endpoint:** 'GET/api/posts/{id}'
  * **Description:** Retrieving a particular post.       
  * **Response:**
    
    ```bash
        {
          "id": 1,
          "title": "Science Research",
          "description": "Scientific Research related post",
          "content": "The research based on the scientifical experiments conducted",
          "comments": [],
          "categoryId": 1
        }

  **Updating a particular Post**
  * **Endpoint:** 'PUT/api/posts/{id}'
  * **Description:** Updating a post name, title, description, content based on the Id.
  * **Request Body:**
    
    ```bash
          {
            "id": 1,
            "title": "Science Research",
            "description": "Updated Scientific Research related post",
            "content": "The research based on the scientifical experiments conducted with updated description",
            "categoryId": 1
          }

  * **Response:**
    
    ```bash
          {
            "id": 1,
            "title": "Science Research",
            "description": "Updated Scientific Research related post",
            "content": "The research based on the scientifical experiments conducted with updated description",
            "comments": [],
            "categoryId": 1
          }

  **Deleting a particular Post**
  * **Endpoint:** 'DELETE/api/posts/{id}'
  * **Description:** Deleting a particular post based on the id.
  * **Response:**
    
    ```bash
          Post Entity deleted successfully

  ### Comments

  **Adding a Comment to a Post**
  * **Endpoint:** 'POST/api/posts/{postId}/comments'
  * **Description:** Adding a comment to a particular post.
  * **Request Body:**
    
    ```bash
      {
        "id": 1,
        "name": "John",
        "email": "john98@gmail.com",
        "body": "Fantastic Science post!"
      }

  * **Response:**
    
    ```bash
        {
          "id": 1,
          "name": "John",
          "email": "john98@gmail.com",
          "body": "Fantastic Science post!"
        }

  **Get all Comments for a particular Post**
  * **Endpoint:** 'GET/api/posts/{postId}/comments'
  * **Description:** Getting all the comments that are commented for a particular post.
  * **Response:**
    
    ```bash
        [
          {
            "id": 1,
            "name": "John",
            "email": "john98@gmail.com",
            "body": "Fantastic Science post!"
          }
        ]

  **Updating a particular Comment for a post**
  * **Endpoint:** 'PUT/api/posts/{postId}/comments/{id}'
  * **Description:** Updating or rewriting a particular comment for a post based on the comment Id.
  * **Request Body:**
    
    ```bash
          {
            "id": 1,
            "name": "John",
            "email": "john98@gmail.com",
            "body": "Updated Fantastic Science post!"
          }

  * **Response:**
    
    ```bash
          {
            "id": 1,
            "name": "John",
            "email": "john98@gmail.com",
            "body": "Updated Fantastic Science post!"
          }

  **Getting a particular Comment for a Post**
  * **Endpoint:** 'GET/api/posts/{postId}/comments/{commentId}'
  * **Description:** Getting a particular comment for a particular post based on the id.
  * **Response:**
    
    ```bash
          {
            "id": 1,
            "name": "John",
            "email": "john98@gmail.com",
            "body": "Updated Fantastic Science post!"
          }

  **Deleting a particular Comment**
  * **Endpoint:** 'DELETE/api/posts/{postsId}/comments/{id}'
  * **Description:** Deleting a particular comment based on the id for a paticular post.
  * **Response:**
    
    ```bash
          Commented deleted successfully
    
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
