#!/bin/bash

TIMESTAMP=$(date +"%Y%m%d%H%M%S")

mvn clean install -DskipTests
mkdir -p target/dependency
cd target/dependency && jar -xf ../*.jar && cd -

docker build -t transaction:$TIMESTAMP .
docker-compose up --build --force-recreate --build-arg TIMESTAMP=$TIMESTAMP
