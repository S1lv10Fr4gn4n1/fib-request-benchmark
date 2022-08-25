# Build stage
FROM gradle:7.4.2-jdk11-alpine as build

WORKDIR /app

COPY . /app

RUN ./gradlew customFatJar


# Runtime stage
FROM adoptopenjdk/openjdk11:jre-11.0.15_10-alpine

WORKDIR /app

COPY --from=build /app/build/libs/fib-java-spark-1.0.jar /app/fib-java-spark-1.0.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx4g", "-jar", "fib-java-spark-1.0.jar"]