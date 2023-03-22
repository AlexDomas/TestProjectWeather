# Test Project Weather

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
