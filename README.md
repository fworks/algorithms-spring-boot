# Algorithms Spring Boot Application 
[![Build Status](https://travis-ci.org/fworks/algorithms-spring-boot.svg?branch=master)](https://travis-ci.org/fworks/algorithms-spring-boot) [![codecov](https://codecov.io/gh/fworks/algorithms-spring-boot/branch/master/graph/badge.svg)](https://codecov.io/gh/fworks/algorithms-spring-boot)

An implementation of basic algorithms and data structures on a microservices architecture, using spring boot / spring cloud libraries.

## Objective

The objective of this project is to implement few basic algorithms (search, sorting, common problems, etc.) and data structures (queue, stack, etc.) on a Spring Boot / Micro Service / containerized project.

I'm using the book Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne, as a base for the algorithms and data structures.

[Book details](https://algs4.cs.princeton.edu/home/)

The idea is to code few of the problems described in the book as spring services, adding some rest controller for testing and execution. I will be using Swagger UI, which will show all the endpoints in a user-friendly way.

All just for playing around with the spring boot microservice world and at same time recall the basis of computing coding.


## Notes

1) I know that most of the implementation could be done in static methods, utility classes, etc.
But I will probably use spring services just to show how that works.

2) I could copy and paste the code from the book and use them.
But I will be testing myself to create them and code them in a way which they will be easier to understand (code style, comments, etc).


## Techs:

Technologies in the project:

- Java 11
- Spring Boot 2.0.5
- String Web (using tomcat at moment, thinking about moving to undertow -[because of that](https://examples.javacodegeeks.com/enterprise-java/spring/tomcat-vs-jetty-vs-undertow-comparison-of-spring-boot-embedded-servlet-containers/))
- Spring Cloud (eureka, zuul, etc.)
- Spring DevTool / Actuator (for speeding up the development/restart, etc)
- Spring Admin (for monitoring)
- Lombok (for avoiding boilerplate code)
- Swagger-ui / OpenApi (for exposing the rest services in an easy/user-friendly web page)
- Log4j2 (for logging)
- jUnit5 (for testing)
- Docker (generate docker image for the microservices, run the application, etc)
- Kubernetes (run in a k8s cluster)

To be added:
- Spring Security / Oauth2 - maybe (for authentication)

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
- Bubblesort ![alt text](https://cdn4.iconfinder.com/data/icons/universal-7/614/11_-_Valid-16.png "Done")
- Heapsort

## Code Structure / Sub projects:

For making thing easier, all microservices project are subproject/modules from this maven project. That will make things easier than have separated git repositories for each one.

I've also added some module prefix for a better understading:
- ms- : for microservices
- lib- : for library/jar 
- server- : for servers
- app: for app gateway

### app-algorithms

Sub project for the app gateway micro service project.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/app-algorithms)

### lib-core

Sub project with few reusable code for the microservices implementation. Just a library.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/lib-core)

### lib-data-structures

Sub project with data structures implementation. Just a library.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/lib-data-structures)

### ms-problems-service

Sub project for the problems microservice.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/ms-problems-service)

### ms-searching-service

Sub project for the searching microservice.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/ms-searching-service)

### ms-sorting-service

Sub project for the sorting microservice.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/ms-sorting-service)

### server-admin

Sub project for the server admin.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/server-admin)

### server-eureka

Sub project for the service discovery - eureka server/service.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/server-eureka)


## Running

#### Option A) 

Faster way, running using the docker images that the last successful build generated.

###### Step 1) Download the file docker-compose.yml

###### Step 2) Open a terminal/powershell, go to the directory of the docker-compose.yml file and run:

```
docker-compose up
```

It should start up all the services.
That is it. Play around and have fun! :)


#### Option B)

Getting the code and compiling and running it.

###### Step 1) Clone the code

###### Step 2) Open a terminal/powershell, go to project root directory and run maven to generate the jars

```
.\mvnw install docker:build -D maven.test.skip=true
```
Note: skipping the testing for speeding up

###### Step 3) Run docker compose to start up all the services  

```
docker-compose up
```

