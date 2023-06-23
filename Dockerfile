FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
COPY target/TestTaskIncode-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]