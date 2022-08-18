FROM maven:3-openjdk-17-slim as builder
COPY pom.xml /build/
COPY src /build/src
WORKDIR /build/
RUN mvn package -Dmaven.test.skip=true

FROM openjdk:17-slim
WORKDIR /app
COPY --from=builder /build/target/selling-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "selling-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080/tcp