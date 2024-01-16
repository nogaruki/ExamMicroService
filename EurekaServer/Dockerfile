# Utiliser une image de base Java 17
FROM openjdk:17-jdk-alpine
LABEL authors="Johann avramov"

# Copier le fichier .jar dans le conteneur
COPY target/EurekaServer-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel le service Eureka va écouter
EXPOSE 8761

# Exécuter l'application
ENTRYPOINT ["java","-jar","/app.jar"]
