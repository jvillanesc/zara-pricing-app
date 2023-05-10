FROM openjdk:8-jre-slim
WORKDIR /home
COPY /target/zara-pricing-app.jar zara-pricing-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "zara-pricing-app.jar"]
