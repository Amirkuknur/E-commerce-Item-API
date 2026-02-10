# Step 1: Build stage (Maven + JDK 21)
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the jar (skip tests for faster builds)
RUN mvn clean package -DskipTests

# Step 2: Run stage (JDK 21 runtime)
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose application port
EXPOSE 8090

# Run Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
