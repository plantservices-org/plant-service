# Build stage
FROM maven:3.9.11-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Final stage
FROM eclipse-temurin:21.0.7_6-jre-alpine-3.21
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

# Metadata
LABEL org.opencontainers.image.authors="Udaykumar Patel <pateluday07@gmail.com>"


