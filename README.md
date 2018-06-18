# Algorithms Spring Boot Application 
[![Build Status](https://travis-ci.org/fworks/algorithms-spring-boot.svg?branch=master)](https://travis-ci.org/fworks/algorithms-spring-boot) [![codecov](https://codecov.io/gh/fworks/algorithms-spring-boot/branch/master/graph/badge.svg)](https://codecov.io/gh/fworks/algorithms-spring-boot)

An implementation of basic algorithms and data structures on a spring boot application.

## Objective

The objective of this project is to implement few basic algorithms (search, sorting, common problems, etc.) and data structures (queue, stack, etc.) on a Spring Boot / Micro Service / containerized project.

I'm using the book Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne, as a base for the algorithms and data structures.

The idea is to code few of the problems described in the book as spring services, adding some rest controller for testing and execution. I will be using Swagger UI, which will show all the endpoints in a user-friendly way.

All just for playing around with the spring boot micro service world and at same time recall the basis of computing coding.

## Notes

I know that most of the implementation could be done in static methods, utility classes, etc.
But I will probably use spring service just to show how that works.


## Techs:

Technologies in the project:

- Java 10
- Spring Boot 2
- String Web (using tomcat at moment, thinking about moving to undertow -[because of that](https://examples.javacodegeeks.com/enterprise-java/spring/tomcat-vs-jetty-vs-undertow-comparison-of-spring-boot-embedded-servlet-containers/))
- Spring DevTool (for speeding up the development/restart, etc)
- Lombok (for avoiding boilerplate code)
- Swagger-ui (for exposing the rest services in an easy/user-friendly web page)
- Log4j2 (for logging)
- jUnit (for testing)

To be added:
- Docker (generate docker image, etc)
- Oauth2 - maybe (for authentication)

## Algorithms:

Data Structures (few implementations: array, linked list, optimized array)
- Bag ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-24.png "Done")
- Queue (FIFO) ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-24.png "Done")
- Stack (LIFO) ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-24.png "Done")
- Deque ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-24.png "Done")
- Steque

Problems:
- Balanced Parentheses (using stack)
- Binary Representation (using stack)
- Josephus Problem (using queue)
- Fibonacci

Searching:
- Brute Force / Sequential ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-24.png "Done")
- Binary Search ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-24.png "Done")

Sorting:
- Bubble Sort
- Selection Sort ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-24.png "Done")
- Insertion Sort ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-24.png "Done")
- Shell Sort
- Merge Sort
- Quick Sort


## Code Structure / Sub projects:

For making thing easier, all microservices project are subproject/modules from this maven project. That will make things easier than have separated git repositories for each one.

### app-algorithms

Sub project for the app gateway project.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/app-algorithms)

### searching-service

Sub project for the searching service.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/searching-service)


### sorting-service

Sub project for the sorting service.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/sorting-service)


## Running

1) Clone the code

2) Few options:

A) On IDE (STS/Eclipse/IntelliJ):
```
run AlgorithmsApplication.java
```
B) On IDE/console - using maven = spring boot maven plugin:
``` 
mvn spring-boot:run
```
C) On console - running the jar:

First generate the jar (skipping the test for speeding up)
```
.\mvnw install -Dmaven.test.skip=true
```
Now just run it:
```
java -jar target/*.jar'
```
Note: Replace *.jar for the fullname jar name

D) Using docker: 

First, generate the jar and the docker image (skipping the tests for speeding up)
```
.\mvnw install docker:build -Dmaven.test.skip=true
```
Now just run a container using the image
```
docker run --name algorithmsboot -p 80:8080 algorithmsboot
```

