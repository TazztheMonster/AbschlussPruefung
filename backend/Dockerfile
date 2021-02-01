FROM maven:3.5-jdk-8 AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package -Dmaven.test.skip=true

FROM openjdk:latest
COPY --from=build /usr/src/app/target/*.jar /usr/app/app.jar  
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ]