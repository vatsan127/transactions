TIMESTAMP=$(date +"%Y%m%d%H%M%S")
mvn clean install -DskipTests
docker build -t transaction:$TIMESTAMP .
docker-compose up --build-arg TIMESTAMP=$TIMESTAMP --file docker-compose.yml -d