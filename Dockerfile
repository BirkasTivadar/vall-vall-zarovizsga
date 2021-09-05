FROM adoptopenjdk:16-jre-hotspot
WORKDIR /opt/app
COPY target/*.jar opt/app/app.jar
CMD ["java", "-jar", "opt/app/app.jar"]
