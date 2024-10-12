FROM eclipse-temurin:21-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/calorias-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]