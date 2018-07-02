## Service Discovery - Eureka

Service discovery implementation using eureka.

http://127.0.0.1:8761/

### Running:

Few options:

A) On IDE (STS/Eclipse/IntelliJ):

```
run ServiceDiscoveryApplication.java
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


D) Using docker (building the image locally): 

First, generate the jar and the docker image (skipping the tests for speeding up)

```
.\mvnw install docker:build -Dmaven.test.skip=true
```

Now just run a container using the image

```
docker run --name algorithmsboot-eureka -p 8761:8761 fworks/algorithmsboot-eureka
```

### Accessing:


eureka ui

```
http://127.0.0.1:8761
```

### Resources:

docker hub image

```
fworks/algorithmsboot-eureka
```
