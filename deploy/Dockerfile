FROM gradle:8.5-jdk17-alpine AS builder

WORKDIR /deploy

COPY . /deploy
RUN ./gradlew clean build -x test

FROM openjdk:17

WORKDIR /deploy
EXPOSE 8080

COPY --from=builder /deploy/build/libs/apro-0.0.1-SNAPSHOT.jar /deploy/app.jar
COPY --from=builder /deploy/deploy/.env /deploy/
COPY . /deploy

RUN export $(cat /deploy/deploy/.env | xargs)
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "-Dserver.port=8080", "app.jar"]