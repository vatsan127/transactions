#!/bin/bash

mvn clean install -DskipTests
mkdir -p target/dependency
cd target/dependency && jar -xf ../../*.jar && cd -

TIMESTAMP=$(date +"%Y%m%d%H%M%S")
echo "Timestamp: $(TIMESTAMP)"

docker tag transactions:latest transactions:$TIMESTAMP
docker build -t transactions:latest .
docker-compose up --file compose.yml
