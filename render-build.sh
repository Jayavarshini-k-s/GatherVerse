#!/usr/bin/env bash
echo "Installing JDK 17..."

sudo apt-get update
sudo apt-get install -y openjdk-17-jdk

export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH

echo "JAVA_HOME is set to: $JAVA_HOME"

./mvnw clean install
