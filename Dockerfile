FROM openjdk:17-jdk

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn

COPY pom.xml .

COPY src src

#-DskipTests  Builda sem rodar testes
RUN ./mvnw package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/gestaoDeResiduos.jar"]