## App Algorithms

App gateway for the microservices implementation.

### Running:

Few options:

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
docker run --name algorithmsboot-app -p 8080:8080 fworks/algorithmsboot-app
```

### Accessing:


swagger-ui

```
http://127.0.0.1:8080/swagger-ui.html
```

### Resources:

docker hub image

```
fworks/algorithmsboot-app
```