# Use JDK 17 official image as the base
FROM openjdk:17-jdk-alpine

# Set working directory in container
WORKDIR /app

# Copy Java source files into the container
COPY src/ ./src

# Compile Java files into /app/bin
RUN mkdir bin && \
    find ./src -name "*.java" > sources.txt && \
    javac -d bin @sources.txt

# Run the main class from Question 1 (Adjust to your actual main class)
CMD ["java", "-cp", "bin", "realconstructor.Main"]
