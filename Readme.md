## Docker Commands

mvn clean install -DskipTests

docker build -t transactions:latest .

docker-compose up -d

docker-compose down --rmi all

## URL
### Brand-Info
http://localhost:8080/transactions/v1/brand-info/
http://localhost:8080/transactions/v1/brand-info/{id}