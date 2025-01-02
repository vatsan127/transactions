#!/bin/bash

mvn clean install -DskipTests
mkdir -p target/dependency
cd target/dependency && jar -xf ../*.jar && cd -

docker tag transactions:latest transactions:$(date +"%Y%m%d%H%M%S")
docker build -t transactions:latest .
docker-compose up
