#FROM eclipse-temurin:17-jdk-focal

#WORKDIR /app

# it doesn't work v
#COPY .mvn/ ./mvn
#COPY mvnw pom.xml ./
# it doesn't work ^

# COPY mvnw .
# COPY .mvn .mvn
# COPY pom.xml .

# RUN chmod +x mvnw

# RUN ./mvnw dependency:go-offline

# COPY src ./src

# CMD ["./mvnw", "spring-boot:run"]


# New Dockerfile

FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/olhovigilante-api-0.0.1-SNAPSHOT.jar olhovigilante-api.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar","olhovigilante-api.jar"]

#additional entrypoint option might be required to fix port future issues: “–server.port=8083”