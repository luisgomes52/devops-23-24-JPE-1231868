# FROM ubuntu:latest
# LABEL authors="luisgomes5216"

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . /app

RUN apt-get update && apt-get install -y dos2unix

RUN dos2unix ./gradlew

RUN chmod +x gradlew

EXPOSE 8080

CMD ["./gradlew", "runServer"]