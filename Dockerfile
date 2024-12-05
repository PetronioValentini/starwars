# Usando a imagem oficial do OpenJDK
FROM openjdk:17-jdk-slim

# Diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo JAR gerado para dentro do container
COPY target/starwars-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta em que o Spring Boot vai rodar (geralmente 8080)
EXPOSE 8080

# Comando para rodar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
