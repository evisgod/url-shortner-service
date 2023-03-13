# Getting started
This is a simple spring boot kotlin based  URL shortener application to short a given url.
Two REST API endpoints has been provided: 
   1. `\shorten` - To short a given URL
   2. `\{hash}`  - To get the actual URL from hash

Since it's an MVP, I tried to keep the project simple and stupid(`KISS`) and used MySQL for data storage.

## Normal Flow: 
    `Once we get the url for shorten, it validates the URL and generates the unique ID
    w.r.t. TimeStamp and Sequence as mentioned here: 
    https://blog.twitter.com/engineering/en_us/a/2010/announcing-snowflake
    After encoded to Base62, we store the value to database and return the shorten value`
     
    `LongURL -> Generate Unique ID -> Base62 -> Store to DB`

## How to run:
You can easily run the project in intelliJ IDE or by using gradle commands in command-line:
        `./gradlew build` and `./gradlew run`

OpenAPI:  http://localhost:8080/swagger-ui/index.html

Note: docker-compose.yml is added for creating the MySQL instance.

## Further Improvements
1. Proper logging can be used with extended libraries like sl4j.
2. For scalability, we can run over application in k8s and scale horizontally. 
3. Since it will be a read heavy system, we need to create read/write replica's.
4. For Latency, we can introduce cacheing strategy for frequently accessing URL's.
5. We can add throttling(rate-limiting) and analytics as per the need.  

## Note: I am still an amateur in kotlin, learned and used it for the first time in this project.





