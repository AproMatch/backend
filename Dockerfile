# base stage: openjdk 17 버전의 alpine 리눅스 환경을 구성
FROM openjdk:17-alpine AS base

# 소스코드를 복사할 작업 디렉토리를 생성
WORKDIR /app

# 라이브러리 설치에 필요한 파일만 복사
COPY build.gradle settings.gradle ./

RUN gradle dependencies --no-daemon

# build stage: 호스트 머신의 소스코드를 작업 디렉토리로 복사하여 빌드
FROM base AS build

COPY . /app

# Gradle 빌드를 실행하여 JAR 파일 생성
RUN gradle clean build --no-daemon

# production stage: 빌드 이미지에서 생성된 JAR 파일을 런타임 이미지로 복사
FROM base AS production

WORKDIR /app

COPY --from=build /app/build/libs/*.jar /app/apro.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "/apro.jar"]
