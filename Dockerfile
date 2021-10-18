FROM bitnami/java:17.0.0
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]