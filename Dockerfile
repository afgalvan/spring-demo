FROM gradle:jdk11 AS dependencies

WORKDIR /api

COPY *gradle* ./

RUN mkdir gradle

RUN mv /api/wrapper /api/gradle

RUN ./gradlew dependencies


FROM dependencies AS build

COPY . .

EXPOSE 8081

CMD [ "./gradlew", "-t", "bootRun" ]