# Use Eclipse Temurin JDK 17 as the base image
FROM eclipse-temurin:17-jdk as builder

# Set the working directory
WORKDIR /app

# Copy the Gradle files
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# Copy the source code
COPY src ./src

# Build the application
RUN ./gradlew build -x test

# Create the runtime image
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"] 