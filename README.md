# GitHubRepo Service

This service provides an interface to fetch the most popular repositories from GitHub based on various filters such as creation date and programming language. It retrieves repositories sorted by the number of stars, and users can request the top 10, 50, 100, etc., repositories.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Running Tests](#running-tests)
- [API Usage](#api-usage)

## Prerequisites

1. **Java JDK 17**: Ensure you have Java 17 installed. 

2. **Maven Wrapper**: The project includes the Maven Wrapper, so you don't need a local Maven installation. We'll use `./mvnw` to execute Maven-related commands.


## Installation

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/kenshinji/GitHubRepo.git
   
   ```


2. **Install Dependencies**:

    ```bash
    ./mvnw install
    
    ```

## Running the Application

Execute the following Maven command:

```bash
./mvnw spring-boot:run

```

After running the above command, the application will start and be accessible at http://localhost:8080.

## Running Tests

To execute the tests, run the following command:

 ```bash
 ./mvnw test
 
 ```

## API Usage

Use the endpoint /top-repositories with optional query parameters:

- date (format: YYYY-MM-DD): Filter repositories based on creation date.
- count: Number of top repositories you want to fetch (e.g., 10, 50, 100).
- language: Filter repositories based on programming language.
Example:

To fetch the top 50 Java repositories since 2023-01-01:

```bash
http://localhost:8080/top-repositories?date=2023-01-01&count=50&language=Java
    
```