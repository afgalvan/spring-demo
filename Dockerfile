FROM gradle:jdk11 AS base
WORKDIR /app
COPY ./ /app

FROM base AS build
WORKDIR /app
RUN gradle clean build

FROM build AS test
WORKDIR /app
ENTRYPOINT ["gradle", "test", "--stacktrace"]
