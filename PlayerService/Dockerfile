FROM openjdk:8-jdk-alpine
LABEL authors="Johann avramov"

#Copie du fichier .jar dans le conteneur
COPY target/PlayerService-0.0.1-SNAPSHOT.jar app.jar

#Exposer le port sur lequel le service va écouter
EXPOSE 8082

#Exécuter l'application
ENTRYPOINT ["java","-jar","/app.jar"]