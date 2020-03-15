FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/graphql-0.0.1-SNAPSHOT.jar graphQLServer.jar
ENTRYPOINT ["java", "-jar", "graphQLServer.jar"]