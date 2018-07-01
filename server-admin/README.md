## Admin Server

Admin server for the spring boot micro services.

http://127.0.0.1:9000/

### Running:

Few options:

A) On IDE (STS/Eclipse/IntelliJ):

```
run ServerAdminApplication.java
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
docker run --name algorithmsboot-admin -p 9000:9000 fworks/algorithmsboot-admin
```

### Accessing:


admin ui

```
http://127.0.0.1:9000
```

### Resources:

docker hub image

```
fworks/algorithmsboot-admin
```