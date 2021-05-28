FROM gradle:jdk11 AS base
WORKDIR /app
COPY ./ /app

FROM base AS database
FROM postgres:13.3-alpine
ENV POSTGRES_PASSWORD=root
ENV POSTGRES_DB=springdemo


FROM database AS build
WORKDIR /app
EXPOSE 8081
ENTRYPOINT ["./gradlew", "clean", "bootRun", "--stacktrace"]
