FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

#COPY .mvn/ ./mvn
#COPY mvnw pom.xml ./
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]