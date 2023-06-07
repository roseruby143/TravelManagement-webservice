FROM openjdk:17

RUN mkdir /tms-app

COPY target/ /tms-app

WORKDIR /tms-app

CMD java -jar travelmanagement-0.0.1-SNAPSHOT.jar --spring.config.name=application.properties