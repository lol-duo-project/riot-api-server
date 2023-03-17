# pre-built image of the JDK 17
FROM openjdk:17-jdk-alpine

# Set the working directory /app
WORKDIR /app

# Copy the Spring Boot jar file into the container
COPY build/libs/*.jar app.jar

# Expose port 8080
EXPOSE 80

# Run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]