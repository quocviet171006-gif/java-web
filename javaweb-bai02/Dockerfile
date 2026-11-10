FROM maven:3.10.0-eclipse-temurin-25-noble AS build

WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM tomcat:11-jre25-temurin-noble

COPY --from=build /build/target/javaweb-bai02.war /usr/local/tomcat/webapps/javaweb-bai02.war

EXPOSE 8080