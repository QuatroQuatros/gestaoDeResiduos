FROM openjdk:17-jdk

WORKDIR /app

COPY target/gestaoDeResiduos-0.0.1-SNAPSHOT.jar /app/gestaoDeResiduos.jar


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "gestaoDeResiduos.jar"]


# COPY  mvnw .
# COPY  .mvn .mvn

# COPY  pom.xml .

# COPY  src src

# #-DskipTests  Builda sem rodar testes
# RUN ./mvnw package -DskipTests

# EXPOSE 8080

# ENTRYPOINT ["java", "-jar", "target/gestaoDeResiduos.jar"]
