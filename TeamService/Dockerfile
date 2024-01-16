FROM openjdk:8-jdk-alpine
LABEL authors="Johann avramov"

#Copie du fichier .jar dans le conteneur
COPY target/TeamService-0.0.1-SNAPSHOT.jar app.jar

#Exposer le port sur lequel le service va écouter
EXPOSE 8081

#Exécuter l'application
ENTRYPOINT ["java","-jar","/app.jar"]