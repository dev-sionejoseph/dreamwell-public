FROM openjdk:17-jdk-slim

WORKDIR /app

COPY pom.xml /app/

COPY src /app/src

ARG DB_USERNAME
ARG DB_PASSWORD

ENV DB_USERNAME=${DB_USERNAME}
ENV DB_PASSWORD=${DB_PASSWORD}

RUN apt-get update && apt-get install -y maven
RUN mvn clean install -U

EXPOSE 8080

CMD ["mvn", "spring-boot:run"]