#!/bin/bash

mvn clean install -DskipTests
mkdir -p target/dependency
cd target/dependency && jar -xf ../*.jar && cd -

TIMESTAMP=$(date +"%Y%m%d%H%M%S")
echo "Timestamp: $(date +"%Y-%m-%d %H:%M:%S")"

docker tag transactions:latest transactions:$(date +"%Y%m%d%H%M%S")
docker build -t transactions:latest .
#docker-compose up --file docker-compose-mysql.yml
docker-compose up --file docker-compose-mariadb.yml
