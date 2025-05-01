# Use OpenJDK 8 as base image
FROM openjdk:8

# Create a working directory inside the container
WORKDIR /app

# Copy the entire source code
COPY ./src /app/src

# Compile all .java files inside the three packages
RUN javac src/lemigohotel/*.java src/realconstructor/*.java src/trafficfinesystem/*.java src/MainLauncher.java

# Run MainLauncher
CMD ["java", "-cp", "src", "MainLauncher"]
