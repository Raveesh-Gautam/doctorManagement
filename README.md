
# Heart Rate Monitoring System

## Description
This project is a Heart Rate Monitoring System that allows users to register and manage their information, add patients, and track their heart rate data. The system uses a REST API built with Spring Boot and connects users with their patients and their health data.

## Setup and Installation

### Prerequisites
- Java 11 or higher
- Spring Boot
- Maven
- MySQL or any other relational database (configure the database connection in `application.properties`)

### Steps to Set Up
1. Clone the repository:
    ```bash
    git clone https://github.com/Raveesh-Gautam/doctorManagement.git
    ```

2. Navigate to the project directory:
    ```bash
    cd project-name
    ```

3. Set up the dependencies:
    ```bash
    mvn clean install
    ```

4. Configure the application properties (e.g., database connection) in `src/main/resources/application.properties`.

5. Run the application:
    ```bash
    mvn spring-boot:run
    ```

### Running Tests
- To run the tests (if applicable):
    ```bash
    mvn test
    ```

## Assumptions and Decisions

### Assumptions
- The system assumes that the users and patients are unique by their email and patient ID, respectively.
- Each patient belongs to a user, and the user can have multiple patients.
- Heart rate data is recorded for each patient.

### Decisions
- I used Spring Boot to create the RESTful API because of its ease of use and integration with Hibernate for ORM.
- MySQL is used for storing user, patient, and heart rate data, but you can configure any database by modifying the `application.properties` file.

## API Documentation

### User API Endpoints

#### 1. `POST /api/user/register`
- **Description:** Register a new user.
- **Request Example:**
    ```json
    {
      "name": "John Doe",
      "email": "john.doe@example.com",
      "password": "password123"
    }
    ```
- **Response Example:**
    ```json
    {
      "message": "User registered successfully"
    }
    ```

#### 2. `POST /api/user/login`
- **Description:** Log in a user with email and password.
- **Request Example:**
    ```bash
    curl -X POST -d "email=john.doe@example.com&password=password123" http://localhost:8080/api/user/login
    ```
- **Response Example:**
    ```json
    {
      "message": "Login successful"
    }
    ```

### Patient API Endpoints

#### 1. `POST /api/patients/{userId}`
- **Description:** Add a new patient for the user with `userId`.
- **Request Example:**
    ```json
    {
      "name": "Jane Doe",
      "age": 30,
      "gender": "FEMALE",
      "contactNumber": "1234567890",
      "address": "123 Main St"
    }
    ```
- **Response Example:**
    ```json
    {
      "message": "Patient added successfully"
    }
    ```

#### 2. `GET /api/patients/user/{userId}`
- **Description:** Get all patients for the user with `userId`.
- **Response Example:**
    ```json
    [
      {
        "patientId": 1,
        "name": "Jane Doe",
        "age": 30,
        "gender": "FEMALE",
        "contactNumber": "1234567890",
        "address": "123 Main St"
      }
    ]
    ```

#### 3. `GET /api/patients/{patientId}/user/{userId}`
- **Description:** Get a specific patient by `patientId` and `userId`.
- **Response Example:**
    ```json
    {
      "patientId": 1,
      "name": "Jane Doe",
      "age": 30,
      "gender": "FEMALE",
      "contactNumber": "1234567890",
      "address": "123 Main St"
    }
    ```

### Heart Rate Data API Endpoints

#### 1. `POST /api/heart-rate/{patientId}`
- **Description:** Add heart rate data for a specific patient.
- **Request Example:**
    ```json
    {
      "heartRate": 75
    }
    ```
- **Response Example:**
    ```json
    {
      "message": "Heart rate data added successfully"
    }
    ```

#### 2. `GET /api/heart-rate/{patientId}`
- **Description:** Get all heart rate data for a specific patient.
- **Response Example:**
    ```json
    [
      {
        "heartRate": 75,
        "recordedAt": "2024-12-14T12:00:00"
      }
    ]
    ```
## Assumptions and Decisions
- User-Patient Relationship: A user can have multiple patients, but each patient is associated with exactly one user.
- Heart Rate Data: Each heart rate data record is tied to a specific patient.
- No Authentication: At the moment, no authentication mechanism is implemented, but this can be added in future versions.

## Future Enhancements
- **Authentication: Implement JWT-based authentication for securing endpoints
- ** Swagger: Use Swagger to document the APIs interactively
- ** We can add more endpoint and implement other user's services
## Contact

- **Name:** Raveesh Gautam
- **Email:** raveeshgautamfzd2002@gmail.com
