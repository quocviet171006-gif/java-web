FROM maven:3.10.0-eclipse-temurin-25 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests package

FROM tomcat:11-jre25-temurin

ENV PORT=10000
COPY --from=build /app/target/javaweb-bai03.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 10000
CMD ["sh", "-c", "sed -i \"s/8080/${PORT}/\" \"$CATALINA_HOME/conf/server.xml\" && catalina.sh run"]