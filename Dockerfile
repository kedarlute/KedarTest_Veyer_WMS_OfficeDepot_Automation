# Use a Maven image with JDK
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /project

# Copy your Maven project files
COPY . .

# Build the project
RUN mvn clean install

# Use a base image with GUI support for Selenium (optional for headless)
FROM selenium/standalone-chrome:latest

# Set workdir inside the container
WORKDIR /project

# Copy built project from previous stage
COPY --from=build /project /project

# Set entry point for test execution
CMD ["mvn", "test"]
