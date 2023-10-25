# Restaurent_Management_Systemservice-API
Restaurant Management System is a Java application built using Maven and the SpringBoot framework.

## Table of Contents

- [Frameworks and Language Used](#frameworks-and-language-used)
- [Dataflow](#dataflow)
- [Data Structure](#data-structure)
- [Project Summary](#project-summary)

## Frameworks and Language Used

- Java: The primary programming language used for developing the application.
- Maven: A build automation tool and dependency management tool used for managing the project's dependencies and building the application.
- SpringBoot: A powerful and widely used framework for building Java-based enterprise applications. It provides features like inversion of control, dependency injection, and seamless integration with various other libraries.

## Dataflow


* Entities : I have 5 enties namely Admin , User , Viewer , FoodItem and Order. All have mappings according to relations.
 
* Controller : I have to five controllers for each entity to make endpoint according to entities basically crud operations.

* Service : Similary for service I have to five service classes for all controller of enties and here I have all my logic and also called crud repo method of jpa for crud operations by the object of it in service class.

* Repository : Basically repository is an interface which is extending CrudRepository of JPA. It is used to to do crud operations on DB. I have a for repo for each entity so total repos are 5.

* DataBase Design : I have used MYSQL as my data base. I have used my sql connector and in applications.properties I have all details about database authentication and which database I am using.

## Data Structure

I have used MYSQL as an database to store my data in persistant way.

## Project Summary

Basically this is applications is for ordering foods via application with signIn/signUp functionalities for user and Admin. Without account user can't do anything.User needs to sign up and then sign in to use application. Admin can use all functionalities.
