FROM gradle:jdk11 AS base
WORKDIR /api
COPY . .
RUN ./gradlew build -x test