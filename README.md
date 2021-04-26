# Accepted Assignment

## Introduction
This application was create within the scope of Accepted interview. The main programming framework used is **2.3.10.RELEASE**.
The project was primarily developed and is tested on **openjdk-11** as well for building and deployment.

## Installation
Java openjdk-11 must be installed and also maven must be installed. Alternatively the maven wrapper included can be used but it is not thoroughly tested. Navigate to project folder and you can start the application by executing `mvn spring-boot:run`
After the application loads just navigate to localhost:8890 and start using the application.

## Testing
### Api Docs
SwaggerUI is used and it is accessible in `/swagger-ui.htm` **HOW EVER** please execute the endpoint `/v2/api-docs` before attempting to read the docs in case the swagger-ui is not displayed.

### Unit Testing
#### Test Creation and Coverage
The application is approx *30%* covered by unit tests. These tests, even though they are not many, have been created in order to focus on key parts of the application due to time pressure.  

## Code Quality
The project is analyzed Sonarqube through a GitHub pipe on each commit. The project can be found here https://sonarcloud.io/dashboard?id=svarvarigou_accepted-assignment 
Sonar reports some false positives regarding code smells that can be explained if needed.

## Tests
Here are some curl examples in order to test the application

### POST method for inserting a Match 
`curl --header "Content-Type: application/json" \
--request POST \
--data '{"description":"This is a test match","match_date":"1987-04-29","match_time":"22:30","team_a":"APOEL","team_b":"AKEL","sport":"1"}' \
http://localhost:8890/match`

### POST method for inserting a MatchOdd
`curl --header "Content-Type: application/json" \
--request POST \
--data '{"match_id":"1","specifier":"X","odd": "1.5"}' \
http://localhost:8890/matchOdds`