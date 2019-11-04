FROM openjdk:8-jre-alpine
WORKDIR /app
EXPOSE 8089 8080
ADD ./build/libs/webfluxproject-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "webfluxproject-0.0.1-SNAPSHOT.jar"]
