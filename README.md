# Zara Pricing App

Zara Pricing App

**Application.properties**

```
spring.datasource.url=jdbc:h2:mem:TEST;DB_CLOSE_DELAY=-1;
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.platform=h2
spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
```

**Run without Docker**

```
> mvn clean install
> java -jar target/zara-pricing-app.jar
```

**Run with Docker**
```
> mvn clean install
> docker build . -t zara-pricing-app
> docker run -d -p 8080:8080 zara-pricing-app

```
