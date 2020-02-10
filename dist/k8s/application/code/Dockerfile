# Build with gradle and JDK 11
FROM gradle:5.6.2-jdk11 as build

WORKDIR /app
COPY ./project/ .
RUN gradle build jar --no-daemon 


# Run with a JRE
FROM openjdk:11-jre-slim

WORKDIR /app
EXPOSE 8080
COPY --from=build /app/build/libs/*.jar /app/spring-boot-application.jar

CMD ["java", "-jar", "spring-boot-application.jar"]