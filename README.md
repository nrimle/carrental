# Carrental

This is the backend of the carrental app.

## Starting the app

To start the app on a local machine, run `gradle build` and `gradle bootRun`, or use the build in capabilities of your
IDE.

## Technologies

This application uses the Spring Boot Framework v3.1.5 with Java sourceCompatibility v17.
Besides the functionalities of Spring boot, this project also uses lombok to reduce boilerplate code.

## Architecture

The app is structured in four main packages, with some additional helper packages:
- Model - structure of the business classes
- Repository - crud interface to the persistent storage
- Service - business logic implementations
- Controller - provides a REST interface for the business logic