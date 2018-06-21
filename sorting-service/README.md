## Sorting Service

Sorting microservice application.

### Running:

Few options:

A) On IDE (STS/Eclipse/IntelliJ):

```
run SortingServiceApplication.java
```

B) On IDE/console - using maven = spring boot maven plugin:

``` 
mvn spring-boot:run
```

C) On console - running the jar:

First generate the jar (skipping the test for speeding up)

```
.\mvnw install -D maven.test.skip=true
```

Now just run it:

```
java -jar target/*.jar'
```

Note: Replace *.jar for the fullname jar name


D) Using docker (building the image locally): 

First, generate the jar and the docker image (skipping the tests for speeding up)

```
.\mvnw install docker:build -D maven.test.skip=true
```

Now just run a container using the image

```
docker run --name algorithmsboot-sorting -p 8082:8080 fworks/algorithmsboot-sorting
```

### Accessing:


swagger-ui

```
http://127.0.0.1:8082/swagger-ui.html
```

### Resources:

docker hub image

```
fworks/algorithmsboot-sorting
```