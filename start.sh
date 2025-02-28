#!/bin/bash

mvn clean install -DskipTests
mkdir -p target/dependency
cd target/dependency && jar -xf ../*.jar && cd -

TIMESTAMP=$(date +"%Y%m%d%H%M%S")
echo "Docker Tag: $(TIMESTAMP)"

docker tag transactions:latest transactions:$TIMESTAMP
docker build -t transactions:latest .