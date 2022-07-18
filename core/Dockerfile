FROM openjdk:11-jre-slim
MAINTAINER driverHub.com
EXPOSE 8082
COPY build/libs/fat-1.4.jar image-fat-1.4.jar
ENTRYPOINT ["java","-jar","image-fat-1.4.jar"]