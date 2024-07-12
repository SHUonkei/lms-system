FROM eclipse-temurin:21

RUN apt-get update && apt-get upgrade -y && apt-get install -y maven
