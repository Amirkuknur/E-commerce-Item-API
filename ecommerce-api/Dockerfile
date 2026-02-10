# Stage 1: Build the application
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Copy Maven wrapper
COPY mvnw .
COPY .mvn .mvn
RUN chmod +x mvnw

# Copy project files
COPY pom.xml .
COPY src src

# Build project
RUN ./mvnw clean package -DskipTests


# Stage 2: Run the built jar
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/target/ecommerce-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
