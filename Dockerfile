# Use a slim OpenJDK image
FROM openjdk:17-slim

# Set the working directory in the container
WORKDIR /app

# Copy compiled Java classes from host to container
COPY bin/ ./bin/

# Set the entrypoint to run your MainLauncher
CMD ["java", "-cp", "bin", "MainLauncher"]
