FROM openjdk:8-jdk-alpine
MAINTAINER pivoterra.co
COPY target/sendemail-0.0.1-SNAPSHOT.jar sendgrid-email-1.0.0.jar
ENTRYPOINT ["java", "-jar","/sendgrid-email-1.0.0.jar"]