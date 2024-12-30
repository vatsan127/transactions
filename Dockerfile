# Stage 1: Build the Java application using Maven (builder stage)
FROM maven:3-amazoncorretto-17-alpine AS builder
WORKDIR /app
COPY . .
RUN mvn clean install

# Stage 2: Run the Java application
FROM amazoncorretto:17-alpine
RUN apk add --no-cache busybox
ENV PROFILE=mysql
WORKDIR /app
COPY --from=builder /app/target/transactions-v1.jar /app/transactions-v1.jar
CMD ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "/app/transactions-v1.jar"]