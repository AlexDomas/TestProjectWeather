FROM openjdk:17
EXPOSE 8080
WORKDIR /authentication/application
COPY /target/TestProjectWeather.jar /authentication/application
ENTRYPOINT ["java","-jar","TestProjectWeather.jar"]