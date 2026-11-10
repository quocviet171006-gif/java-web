FROM maven:3.9-eclipse-temurin-25 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM tomcat:11-jdk25-temurin
COPY --from=build /app/target/javaweb-bai01.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 10000
CMD ["sh", "-c", "sed -i \"s/8080/${PORT:-10000}/\" /usr/local/tomcat/conf/server.xml && catalina.sh run"]