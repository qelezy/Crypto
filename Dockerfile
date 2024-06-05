FROM maven:3.9.6-eclipse-temurin-21 as build
WORKDIR /app
COPY mvnw pom.xml ./
COPY . .
RUN mvn clean install -DskipTests

FROM eclipse-temurin:21
WORKDIR /app
EXPOSE 8080
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]