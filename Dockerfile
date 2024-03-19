FROM openjdk:17-oracle
COPY target/*.jar toilet-apps.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "toilet-apps.jar"]