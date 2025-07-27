#!/bin/bash

echo "Using Java version:"
java -version

echo "Starting Maven build..."
./mvnw clean install -DskipTests
