#!/bin/bash

echo "Using Java version:"
java -version

echo "Building Spring Boot application..."
./mvnw clean install -DskipTests

echo "Build completed"

