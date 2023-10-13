FROM openjdk:21
COPY target/hero-1.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "hero-1.0.1-SNAPSHOT.jar"]