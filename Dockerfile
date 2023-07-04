FROM openjdk:20
ADD target/sb-app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]