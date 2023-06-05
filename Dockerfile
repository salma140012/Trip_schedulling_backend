FROM openjdk:15
EXPOSE 8080
ENV MYSQL_HOST=host.docker.internal
ENV MYSQL_PORT=3306
ENV MYSQL_USER=userroot
ENV MYSQL_PASSWORD=root
COPY target/tripscheduling.jar tripscheduling.jar
ENTRYPOINT ["java","-jar","/tripscheduling.jar","-ENV=${MYSQL_HOST}","-ENV=${MYSQL_PORT}","-ENV=${MYSQL_USER}","-ENV=${MYSQL_PASSWORD}"]



