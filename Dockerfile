ENV POSTGRES_PASSWORD=root
ENV POSTGRES_DB=springdemo

FROM gradle:jdk11 AS base
WORKDIR /app
COPY ./ /app

FROM base AS database
FROM postgres:13.3-alpine

FROM database AS build
WORKDIR /app
ENTRYPOINT ["./gradlew", "clean", "bootRun", "--stacktrace"]
