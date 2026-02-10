# ===== Stage 1: Build the application using Maven (JDK 21) =====
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom.xml and download dependencies first (cache optimization)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the full project
COPY src ./src

# Build the project (skip tests for faster build)
RUN mvn clean package -DskipTests


# ===== Stage 2: Run the application (JRE 21) =====
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the jar file from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose your server port (your app uses 8090)
EXPOSE 8090

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
