FROM openjdk:10-jdk-slim
VOLUME /tmp
ARG JAR_FILE
COPY *.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=staging","-jar","/app.jar"]