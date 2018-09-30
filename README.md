# Algorithms Spring Boot Application 
[![Build Status](https://travis-ci.org/fworks/algorithms-spring-boot.svg?branch=master)](https://travis-ci.org/fworks/algorithms-spring-boot) [![codecov](https://codecov.io/gh/fworks/algorithms-spring-boot/branch/master/graph/badge.svg)](https://codecov.io/gh/fworks/algorithms-spring-boot)

An implementation of a few basic algorithms and data structures on a microservices architecture, using the latest tech around spring boot / spring cloud.

## Objective

The objective of this project is to implement few basic algorithms (search, sorting, common problems, etc.) and data structures (queue, stack, etc.) on a Spring Boot / Microservice / containerized project.

I'm using the book [Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne](https://algs4.cs.princeton.edu/home/), as a base for the algorithms and data structures.

The idea is to code a few of the problems described in the book as spring services, adding some rest controller for testing and execution. Probably I will add some front-end one day, but for now all endpoints will be exposed by Swagger UI.

All just for playing around with the spring boot microservice world and at same time recall the basis of computing coding.


## Notes

1) I know that most of the implementation could be done in static methods, utility classes, etc.
But I will probably use spring services just to show how that works.
2) I could copy and paste the code from the book and use them.
But I will be testing myself to create them and code them in a way which they will be easier to understand (code style, comments, etc).


## Techs:

Technologies in the project:

- [x] Java 11
- [x] Spring Boot 2.0.5
- [x] Spring Web (using tomcat at moment, thinking about moving to undertow -[because of that](https://examples.javacodegeeks.com/enterprise-java/spring/tomcat-vs-jetty-vs-undertow-comparison-of-spring-boot-embedded-servlet-containers/))
- [x] Spring Cloud (eureka, zuul, etc.)
- [x] Spring DevTool / Actuator (for speeding up the development/restart, etc)
- [x] Spring Admin (for monitoring)
- [x] Lombok (for avoiding boilerplate code)
- [x] Swagger-ui / OpenApi (for exposing the rest services in an easy/user-friendly web page)
- [x] Log4j2 (for logging)
- [x] jUnit5 (for testing)
- [x] Docker (generate docker image for the microservices, run the application, etc)
- [ ] Kubernetes (run in a k8s cluster)
- [x] MongoDB
- [x] Mysql
- [x] Postgresql

To be added:
- Spring Security / Oauth2 - maybe (for authentication)

## Algorithms:

Data Structures (few implementations: array, linked list, optimized array)
- [x] Bag
- [x] Queue (FIFO)
- [x] Stack (LIFO)
- [x] Deque
- [ ] Steque
- [ ]  Priority Queue
- [ ]  Generalized Queue
- [ ]  Random Queue
- [ ]  Random Bag
- [ ]  Buffer
- [ ]  Ring Buffer

Problems:
- [x] Balanced Parentheses (using stack)
- [ ] Binary Representation (using stack)
- [x] Josephus Problem (using queue)
- [x] Fibonacci
- [x] Prime Numbers

Searching:
- [x] Brute Force / Sequential
- [x] Binary Search

Sorting:
- [x] Selection Sort
- [x] Insertion Sort
- [x] Shellsort
- [x] Mergesort
- [x] Quicksort
- [x] Quick3way
- [x] Bubblesort
- [ ] Heapsort

## Code Structure / Subprojects:

For making thing easier, all microservices projects are subproject/modules from this maven project. That will make things easier than have separated git repositories for each one.

I've also added some module prefix for a better understanding:
- ms- : for microservices
- lib- : for library/jar 
- server- : for servers
- app: for app gateway

### app-algorithms

Subproject for the app gateway micro service project.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/app-algorithms)

### lib-core

Subproject with few reusable codes for the microservices implementation. Just a library.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/lib-core)

### lib-data-structures

Subproject with data structures implementation. Just a library.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/lib-data-structures)

### ms-problems-service

Subproject for the problems microservice.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/ms-problems-service)

### ms-searching-service

Subproject for the searching microservice.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/ms-searching-service)

### ms-sorting-service

Subproject for the sorting microservice.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/ms-sorting-service)

### server-admin

Subproject for the server admin.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/server-admin)

### server-eureka

Subproject for the service discovery - eureka server/service.

[See the README.md for the subproject](https://github.com/fworks/algorithms-spring-boot/tree/master/server-eureka)


## Running

#### Option A) 

The faster way, running using the docker images that the last successful build generated.

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

