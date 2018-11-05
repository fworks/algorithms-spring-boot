## Algorithms Microservices Spring Boot Application 
[![CircleCI](https://circleci.com/gh/fworks/algorithms-spring-boot.svg?style=svg)](https://circleci.com/gh/fworks/algorithms-spring-boot)[![Build Status](https://travis-ci.org/fworks/algorithms-spring-boot.svg?branch=master)](https://travis-ci.org/fworks/algorithms-spring-boot) [![codecov](https://codecov.io/gh/fworks/algorithms-spring-boot/branch/master/graph/badge.svg)](https://codecov.io/gh/fworks/algorithms-spring-boot)

This project is a test bed for microservices applications running on the latest technologies around Java + Spring + Containers.

## Keys focus
1) all microservices
2) all containerized
3) latest versions
4) multiple databases
5) code coverage > 90%
6) clear code
7) build always passing
8) always a work in progress
 
## Techs
- [x] Java 11
- [x] Spring Boot 2.0.5
- [x] Spring Web (using tomcat at moment, thinking about moving to undertow -[because of that](https://examples.javacodegeeks.com/enterprise-java/spring/tomcat-vs-jetty-vs-undertow-comparison-of-spring-boot-embedded-servlet-containers/))
- [x] Spring Cloud (eureka, zuul, etc.)
- [x] Spring DevTool / Actuator (for speeding up the development/restart, etc)
- [x] Spring Admin (for monitoring)
- [ ] Spring Security / Oauth2 (for authentication)
- [x] Lombok (for avoiding boilerplate code)
- [x] Swagger-ui / OpenApi (for exposing the rest services in an easy/user-friendly web page)
- [x] Log4j2 (for logging)
- [x] jUnit5 (for testing)
- [x] Docker (generate docker image for the microservices, run the application, etc)
- [ ] Kubernetes (run in a k8s cluster)
- [x] MongoDB
- [x] Mysql
- [ ] Postgresql

## Subject
For avoiding having a poor example of data, the subject of the microservices will be around Algorithms and Data Structures.
So, the microservices will implement a few of the basic algorithms (search, sorting, common problems, etc.).
I'm using the book [Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne](https://algs4.cs.princeton.edu/home/), as a base for the algorithms and data structures.

## Implementation Notes
1) I know that most of the implementation of the algorithms could be done in static methods, utility classes, etc. However, I will use spring services just to show how that works.
2) I could copy and paste the code from the book and use them.
But I will be testing myself to create them and code them in a way which they will be easier to understand (code style, comments, etc).

## Code Structure / Subprojects
For making things easier, all microservices projects are subproject/modules from this maven project. That will make things easier than have separated git repositories for each one.

I've also added some module prefix for a better understanding:
- __ms-__ : for microservices
- __lib-__ : for library/jar 
- __server-__ : for servers
- __app-__: for app gateway

## Subprojects
[__app-algorithms__](https://github.com/fworks/algorithms-spring-boot/tree/master/app-algorithms) > Subproject for the app gateway microservice project.

[__lib-core__](https://github.com/fworks/algorithms-spring-boot/tree/master/lib-core) > Subproject with few reusable codes for the microservices implementation. Just a library.

[__lib-data-structures__](https://github.com/fworks/algorithms-spring-boot/tree/master/lib-data-structures) > Subproject with data structures implementation. Just a library.

[__ms-problems-service__](https://github.com/fworks/algorithms-spring-boot/tree/master/ms-problems-service) > Subproject for the problems microservice.

[__ms-searching-service__](https://github.com/fworks/algorithms-spring-boot/tree/master/ms-searching-service) > Subproject for the searching microservice.

[__ms-sorting-service__](https://github.com/fworks/algorithms-spring-boot/tree/master/ms-sorting-service) > Subproject for the sorting microservice.

[__server-admin__](https://github.com/fworks/algorithms-spring-boot/tree/master/server-admin) > Subproject for the server admin.

[__server-eureka__](https://github.com/fworks/algorithms-spring-boot/tree/master/server-eureka) > Subproject for the service discovery - eureka server/service.

## See it running
The apps are deployed as containers on the cloud. Please feel free to test it.

Eureka Server:
[![Website](https://img.shields.io/website-up-down-green-red/http/algorithms-spring-boot.fworks.tech:8761.svg)](http://algorithms-spring-boot.fworks.tech:8761/)

Admin Server:
[![Website](https://img.shields.io/website-up-down-green-red/http/algorithms-spring-boot.fworks.tech:9000.svg)](http://algorithms-spring-boot.fworks.tech:9000/)

App Algorithms:
[![Website](https://img.shields.io/website-up-down-green-red/http/algorithms-spring-boot.fworks.tech:8080/swagger-ui.html.svg)](http://algorithms-spring-boot.fworks.tech:8080/swagger-ui.html)

Searching Service:
[![Website](https://img.shields.io/website-up-down-green-red/http/algorithms-spring-boot.fworks.tech:8081/swagger-ui.html.svg)](http://algorithms-spring-boot.fworks.tech:8081/swagger-ui.html)

Sorting Service:
[![Website](https://img.shields.io/website-up-down-green-red/http/algorithms-spring-boot.fworks.tech:8082/swagger-ui.html.svg)](http://algorithms-spring-boot.fworks.tech:8082/swagger-ui.html)

Problems Service:
[![Website](https://img.shields.io/website-up-down-green-red/http/algorithms-spring-boot.fworks.tech:8083/swagger-ui.html.svg)](http://algorithms-spring-boot.fworks.tech:8083/swagger-ui.html)

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

