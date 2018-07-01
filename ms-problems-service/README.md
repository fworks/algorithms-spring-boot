## Problems Service

Problems microservice application.

### Running:

Few options:

A) On IDE (STS/Eclipse/IntelliJ):

```
run ProblemsServiceApplication.java
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
docker run --name algorithmsboot-problems -p 8083:8080 fworks/algorithmsboot-problems
```

### Accessing:


swagger-ui

```
http://127.0.0.1:8083/swagger-ui.html
```

### Resources:

docker hub image

```
fworks/algorithmsboot-problems
```
