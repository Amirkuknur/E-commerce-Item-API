# Build Stage
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Go inside the subfolder
WORKDIR /app/ecommerce-api

# Copy only subfolder
COPY ecommerce-api/pom.xml .
COPY ecommerce-api/src ./src
COPY ecommerce-api/mvnw .
COPY ecommerce-api/.mvn .mvn
RUN chmod +x mvnw

# Build jar
RUN ./mvnw clean package -DskipTests


# Run Stage
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/ecommerce-api/target/ecommerce-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
