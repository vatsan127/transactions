# Stage 1: Build the Java application using Maven (builder stage)
FROM maven:3-amazoncorretto-17-alpine AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve
COPY . .
RUN mvn clean install -DskipTests

# Stage 2: Run the Java application
FROM amazoncorretto:17-alpine
RUN apk add --no-cache busybox
WORKDIR /app
COPY --from=builder /app/target/transactions-v1.jar /app/transactions-v1.jar
CMD ["java", "-jar", "/app/transactions-v1.jar"]