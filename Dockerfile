# Use Eclipse Temurin JDK 21 as the base image
FROM eclipse-temurin:21-jdk as builder

# Set the working directory
WORKDIR /app

# Copy the Gradle files
COPY build.gradle settings.gradle ./
COPY gradle ./gradle
COPY gradlew ./

# Make gradlew executable
RUN chmod +x ./gradlew

# Copy the source code
COPY src ./src

# Build the application
RUN ./gradlew build -x test --no-daemon --info --stacktrace

# Create the runtime image
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"] 