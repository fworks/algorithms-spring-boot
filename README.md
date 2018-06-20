# Algorithms Spring Boot Application 
[![Build Status](https://travis-ci.org/fworks/algorithms-spring-boot.svg?branch=master)](https://travis-ci.org/fworks/algorithms-spring-boot) [![codecov](https://codecov.io/gh/fworks/algorithms-spring-boot/branch/master/graph/badge.svg)](https://codecov.io/gh/fworks/algorithms-spring-boot)

An implementation of basic algorithms and data structures on a microservices architecture, using spring boot / spring cloud libraries.

## Objective

The objective of this project is to implement few basic algorithms (search, sorting, common problems, etc.) and data structures (queue, stack, etc.) on a Spring Boot / Micro Service / containerized project.

I'm using the book Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne, as a base for the algorithms and data structures.

[Book details](https://algs4.cs.princeton.edu/home/)

The idea is to code few of the problems described in the book as spring services, adding some rest controller for testing and execution. I will be using Swagger UI, which will show all the endpoints in a user-friendly way.

All just for playing around with the spring boot micro service world and at same time recall the basis of computing coding.


## Notes

1) I know that most of the implementation could be done in static methods, utility classes, etc.
But I will probably use spring services just to show how that works.

2) I could copy and paste the code from the book and use them.
But I will be testing myself to create them and code them in a way which they will be easier to understand (code style, comments, etc).


## Techs:

Technologies in the project:

- Java 10 (yes I know, should I wait for the 11, but it will be nice)
- Spring Boot 2
- String Web (using tomcat at moment, thinking about moving to undertow -[because of that](https://examples.javacodegeeks.com/enterprise-java/spring/tomcat-vs-jetty-vs-undertow-comparison-of-spring-boot-embedded-servlet-containers/))
- Spring Cloud (eureka, etc.)
- Spring DevTool / Actuator (for speeding up the development/restart, etc)
- Lombok (for avoiding boilerplate code)
- Swagger-ui (for exposing the rest services in an easy/user-friendly web page)
- Log4j2 (for logging)
- jUnit (for testing)
- Docker (generate docker image for the microservices, run the application, etc)

To be added:
- Oauth2 - maybe (for authentication)

## Algorithms:

Data Structures (few implementations: array, linked list, optimized array)
- Bag ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")
- Queue (FIFO) ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")
- Stack (LIFO) ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")
- Deque ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")
- Steque
- Priority Queue
- Generalized Queue
- Random Queue
- Random Bag
- Buffer
- Ring Buffer

Problems:
- Balanced Parentheses (using stack) ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")
- Binary Representation (using stack)
- Josephus Problem (using queue) ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")
- Fibonacci ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")
- Prime Numbers ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")

Searching:
- Brute Force / Sequential ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")
- Binary Search ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")

Sorting:
- Selection Sort ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")
- Insertion Sort ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")
- Shellsort ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")
- Mergesort ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")
- Quicksort ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")
- Quick3way ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")
- Bubblesort
- Heapsort

## Code Structure / Sub projects:

For making thing easier, all microservices project are subproject/modules from this maven project. That will make things easier than have separated git repositories for each one.

### app-algorithms

Sub project for the app gateway micro service project.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/app-algorithms)

### data-structures

Sub project with data structures library implementation.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/data-structures)

### searching-service

Sub project for the searching micro service.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/searching-service)

### service-discovery

Sub project for the service discovery - eureka server/service.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/service-discovery)

### sorting-service

Sub project for the sorting micro service.

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

