# Test Project Weather

### How to start application

#### You can choose where to start application: docker-container or your host.
1. Starting as host: set (spring.profiles.active=host) in application.properties and run your application.
2. Starting in docker container: set (spring.profiles.active=container) in application.properties 
and go to the root project directory, compile jar-file with the help of maven command (mvn clean, mvn package -Dmaven.test.skip), call terminal and perform (docker compose up). 

### Swagger

http://localhost:8080/swagger-ui.html#/weather45rest45controller

### Endpoints

First EndPoint

http://localhost:8080/api/v1/weather/last-weather

Second EndPoint

http://localhost:8080/api/v1/weather/between-date?from={from_date}&to={date_to}

Values {from_date} and {date_to} included

### Application properties

#### Datasource properties:

spring.jpa.properties.hibernate.dialect
#####
spring.datasource.url
#####
spring.datasource.username
#####
spring.datasource.password

#### The city for which the weather will be obtained:

param.city={city}

#### RapidAPI - My Key:

api.key.rapidapi={key}

#### If you want to change timer of requests, you can change fixedRate param in class WeatherInfoJob
