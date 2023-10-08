# GitHubRepo Service

This service provides an interface to fetch the most popular repositories from GitHub based on various filters such as creation date and programming language. It retrieves repositories sorted by the number of stars, and users can request the top 10, 50, 100, etc., repositories.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Running Tests](#running-tests)
- [Assumptions and Default Values](#assumptions-and-default-values)
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

## Assumptions and Default Values
While building this service, certain assumptions were made regarding input parameters to ensure a smooth user experience. They are as follows:

1. Date Parameter (date):

If the user does not provide a specific date when querying for popular repositories, the service assumes the user is interested in repositories created as of the current date.
For instance, if querying on October 10th, 2023 without specifying a date, the service will default to considering repositories created on 2023-10-10.

2. Top Repositories Parameter (count):

The service returns a list of the most popular repositories, sorted by number of stars. If the user does not specify how many repositories they want (e.g., top 10, 50, 100), the service defaults to returning the top 10 repositories.
This ensures that even if the user is unsure about the exact number of repositories they want to view, they will still get a concise list of the most popular ones.


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