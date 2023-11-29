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
     

2. Navigate to the project directory:

   ```bash
   cd Splitwise

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

### End Points

  ### Users

  **Creating Users**
  * **Endpoint:** 'POST/user/registeruser'
  * **Description:** Create/Register a new user 
  * **Request Body:**
    
    ```bash
          {
            "name" : "Mark",
            "email" : "mark45@gmail.com",
            "phoneNumber" : "8529647650"
          }
          
  * **Response:**
    
    ```bash
        {
            "name": "Mark",
            "email": "mark45@gmail.com",
            "phoneNumber": "8529647650"
        }
    
  
  **Adding Users to a group**
  * **Endpoint:** 'POST/user/{userId}/addGroup/{groupId}'
  * **Description:** After registering the users, we can add users to any group 
  * **Request Parameters**
    
    ```bash
      http://localhost:8080/user/2/addGroup/2          
  * **Response:**
    
    ```bash
      User added to the Group successfully
  
  **Getting group information for any user**
  * **Endpoint:** 'POST/user/{userId}/groups}'
  * **Description:** Getting the group data for a particular user 
  * **Request Parameters:**
    
    ```bash
      http://localhost:8080/user/2/groups
            
  * **Response:**
    
    ```bash
        [
          {
            "headers": {},
            "body": {
              "groupName": "Tracking Expenses",
              "description": "To Track all the Expenses spent ",
              "defaultCurrency": "INR"
            },
            "statusCode": "OK",
            "statusCodeValue": 200
          },
          {
            "headers": {},
            "body": {
              "groupName": "Goa Trip Expense Tracking",
              "description": "To track expense for the goa trip",
              "defaultCurrency": "INR"
            },
            "statusCode": "OK",
            "statusCodeValue": 200
          }
      ]


### Groups

  **Creating Group**
  * **Endpoint:** 'POST/group/create'
  * **Description:** Creating a new group
  * **Request Body:**
    
    ```bash
          {
            "groupName" : "Trip Expenses Group",
            "description" : "Created this group for the upcoming trip",
            "defaultCurrency" : "INR"
          }
          
  * **Response:**
    
    ```bash
        {
          "groupName": "Trip Expenses Group",
          "description": "Created this group for the upcoming trip",
          "defaultCurrency": "INR"
        }
    
  
  **Settling up the User Expenses**
  * **Endpoint:** 'GET/group/settleup/{groupId}'
  * **Description:** Settling up all the user expenses in the group 
  * **Request Parameters**
    
    ```bash
      http://localhost:8080/group/settleup/2          
  * **Response:**
    
    ```bash
      [
        {
          "fromUserName": "D",
          "toUserName": "A",
          "amount": 600.0
        },
        {
          "fromUserName": "C",
          "toUserName": "B",
          "amount": 400.0
        },
        {
          "fromUserName": "C",
          "toUserName": "A",
          "amount": 200.0
        }
      ]

  
  **Total Amount Spent by a Group**
  * **Endpoint:** 'GET/group/{groupId}/totalAmount}'
  * **Description:** Getting the total amount spent by a group 
  * **Request Parameters:**
    
    ```bash
      http://localhost:8080/group/2/totalAmount            
  * **Response:**
    
    ```bash
     Total Amount spent by the Group is : 3000.0

### Expense

  **Creating Expense**
  * **Endpoint:** 'POST/expense/{groupId}/create-expense'
  * **Description:** Creating a new expense for existing group
  * **Request Body:**
    
    ```bash
          {
            "description" : "Food Expenses",
            "currency" : "INR"
          }          
  * **Response:**
    
    ```bash
        {
          "description": "Food Expenses",
          "currency": "INR"
        }

  **Total Amount for an expense**
  * **Endpoint:** 'GET/expense/{expenseId}/totalAmount}'
  * **Description:** Getting the total amount spent for a particular expense 
  * **Request Parameters:**
    
    ```bash
      http://localhost:8080/expense/1/totalAmount           
  * **Response:**
    
    ```bash
     The total Amount spent is : 3000.0

### UserExpense

  **Creating a User Expense**
  * **Endpoint:** 'POST/userexpense/{userId}/createexpense'
  * **Description:** Creating a new user expense that an existing user made
  * **Request Body:**
    
    ```bash
          {
            "amount" : 600,
            "userExpenseType" : "HADTOPAY"
          }          
  * **Response:**
    
    ```bash
        User Expense added!

  **User Expense to Group Expense**
  * **Endpoint:** 'POST/userexpense/{expenseId}/adduserexpense/{userExpenseId}'
  * **Description:** Adding a single user expense to a group expense
  * **Request Parameters:**
    
    ```bash
      http://localhost:8080/userexpense/2/adduserexpense/10            
  * **Response:**
    
    ```bash
     User Expense successfully added to a Group Expense
    
## Configuration
### Application Properties

The main configuration for the Splitwise project is stored in the `src/main/resources/application.properties` file. 
Below are key configurations that you may want to customize:

  **Database Configuration**
  
    spring.datasource.url=jdbc:mysql://localhost:3306/splitwise
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
- **Issue Tracker:** [GitHub Issues](https://github.com/SujiV-repo/Splitwise/issues)
