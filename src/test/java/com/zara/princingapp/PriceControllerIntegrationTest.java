package com.zara.princingapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.zara.princingapp.model.Price;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PriceControllerIntegrationTest {

  String host;
  Integer brandId;
  Integer productId;
  @LocalServerPort
  private int port;
  @Autowired
  private TestRestTemplate restTemplate;

  @BeforeAll
  void beforeAll() {
    System.out.println("Initializing test");
    host = "http://localhost:";
    brandId = 1;
    productId = 35455;
  }

  @ParameterizedTest
  @CsvSource({
    "2020-06-14T10:00:00, 35.50",
    "2020-06-14T16:00:00, 25.45",
    "2020-06-14T21:00:00, 35.50",
    "2020-06-15T10:00:00, 30.50",
    "2020-06-16T21:00:00, 38.95"
  })

  @DisplayName("return correct price when get it in existing period")
  void returnCorrectPriceWhenGetItInExistingPeriod(String date, Double priceValue) {
    Price price = this.restTemplate
                   .getForObject(host + port
                           + "/price?brandId=" + brandId
                           + "&productId=" + productId
                           + "&date=" + date, Price.class);
    assertEquals(priceValue, price.getPriceValue());
  }

  @Test
  @DisplayName("return error when get it in not existing period")
  void returnNotFoundPriceWhenGetItInNotExistingPeriod() {
    String date = "2020-06-13T21:00:00";
    ResponseEntity<Void> responseEntity = this.restTemplate
             .getForEntity(host + port
                     + "/price?brandId=" + brandId
                     + "&productId=" + productId
                     + "&date=" + date, Void.class);
    assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
  }

}

