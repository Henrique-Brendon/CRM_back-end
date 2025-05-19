FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Expõe a porta da API
EXPOSE 8080

# Copia o JAR gerado do build para o container final
COPY --from=build /app/target/*.jar app.jar

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
