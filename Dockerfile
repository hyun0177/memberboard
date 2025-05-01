# 1. OpenJDK 21 이미지를 사용합니다.
FROM openjdk:21-jdk-slim AS build

# 2. 작업 디렉토리를 설정합니다.
WORKDIR /app

# 3. Spring Boot 애플리케이션의 JAR 파일을 빌드합니다.
COPY build/libs/*.jar app.jar

# 4. Spring Boot 애플리케이션을 실행합니다.
ENTRYPOINT ["java", "-jar", "/app/app.jar"]