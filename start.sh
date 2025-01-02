TIMESTAMP=$(date +"%Y%m%d%H%M%S")
mvn clean install -DskipTests
mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
docker build -t transaction:$TIMESTAMP .
docker-compose up --build-arg TIMESTAMP=$TIMESTAMP --file docker-compose.yml -d