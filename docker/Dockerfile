FROM openjdk:23-ea

ARG APPB_JAR=*.jar

COPY ${APPB_JAR} appb.jar

ENTRYPOINT ["java", "-jar", "appb.jar"]

EXPOSE 8080