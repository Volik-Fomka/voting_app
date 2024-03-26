# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app

# Copy source code to the container
COPY src ./src
COPY pom.xml .

# Package the application
RUN mvn clean package -DskipTests

# Stage 2: Create the final Docker image
FROM openjdk:17-slim
COPY --from=build /app/target/voting-service-0.0.1-SNAPSHOT.jar /voting-service.jar
ENTRYPOINT ["java","-jar","/voting-service.jar"]
