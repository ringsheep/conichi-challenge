FROM openjdk:8-jdk-alpine
EXPOSE 8081
ARG JAR_FILE=build/libs/conichi-challenge-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} conichi-challenge-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/conichi-challenge-0.0.1-SNAPSHOT.jar"]