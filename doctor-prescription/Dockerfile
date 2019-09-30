# Base Image
FROM openjdk:8-jdk-alpine

# Working directory for Tomcat.
VOLUME /tmp

# Copy jar file of API from host to container.
COPY ./config/target/config-0.0.1-SNAPSHOT.jar /opt/app/

# Start API.
ENTRYPOINT ["java", "-jar", "/opt/app/config-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080