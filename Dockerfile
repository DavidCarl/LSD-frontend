FROM maven:3.3-jdk-8 AS build-env

COPY LSD-frontend /app
COPY settings.xml /root/.m2/settings.xml
WORKDIR /app
RUN mvn clean package

FROM tomcat:9.0.1-alpine

COPY --from=build-env /app/target/LSD-frontend.war /usr/local/tomcat/webapps/LSD-frontend.war
EXPOSE 8080
