FROM openjdk:17
WORKDIR /app
COPY . /app
# Compile all Java files
RUN javac src/lemigohotel/*.java src/realconstructor/*.java src/trafficfinesystem/*.java -d bin/
CMD ["java", "-cp", "bin", "MainLauncher"]