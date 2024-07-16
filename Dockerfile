FROM eclipse-temurin:21

RUN apt-get update && apt-get upgrade -y && apt-get install -y maven
RUN apt-get install -y sqlite3