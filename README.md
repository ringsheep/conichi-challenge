# Conichi coding challenge
This project illustrates three different data types (date, currency and vat) for the purpose of coding challenge and for sample calculations.
Third-party APIs are used to get actual currency rates and vat validation. 

## Quick start
Docker way:
```
./gradlew clean build && docker build -t conichi-challenge . && docker run -it -p 8081:8081 conichi-challenge:latest
```
Simple jar launch:
```
./gradlew clean build && java -jar build/libs/conichi-challenge-0.0.1-SNAPSHOT.jar 
```

## Functionality
(TODO: export to swagger)
* Get current date by `/api/date/current`
```
curl -X GET http://localhost:8081/api/date/current
```
* Convert source amount and currency to target currency by `/api/currency/convert`
```
curl -X GET 'http://localhost:8081/api/currency/convert?sourceAmount=144500.00&sourceCurrencyCode=RUB&targetCurrencyCode=USD' -H 'Content-Type: application/json'
```
* Validate VAT code by `/api/vat/validate`
```
curl -X GET 'http://localhost:8081/api/vat/validate?vatCode=DE%20260543043' -H 'Content-Type: application/json'
```

## Technologies & frameworks: 
* Kotlin, Spring Boot, Feign, Junit
* Was written in a single night :)

## Requirements
* JDK 8

## TODOs and other stuff I lacked time for
* Externalize api keys injection through docker volume
* Pass jar name to Dockerfile to avoid version hard-coding
* Integration tests using WireMock
* Caching for VAT requests (because date and currencies are updating constantly)
* Swagger documentation