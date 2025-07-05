package com.project.sajee.order;

import com.project.sajee.order.stub.InventoryClientStup;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;

import static org.hamcrest.MatcherAssert.assertThat;

@Import(TestcontainersConfiguration.class)
//this tells Spring Boot to start the embedded web server on a random port to avoid port conflicts during tests
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0) // set random port
class OrderServiceApplicationTests {

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void shouldPlacedOrder() {
        String orderRequestJson = """
                {
                    "code": "samsung_tv",
                    "price": 200000,
                    "quantity": 5
                }
                """;

        InventoryClientStup.callForPositive("samsung_tv", 5);

        RestAssured
                .given()
                .contentType("application/json")
                .body(orderRequestJson)
                .when()
                .post("/api/v1.0/order/add")
                .then()
                .log().all()
                .statusCode(201)
                .body("message", Matchers.equalTo("order placed successfully!"))
                .body("order.id", Matchers.notNullValue())
                .body("order.orderNumber", Matchers.notNullValue())
                .body("order.code", Matchers.equalTo("samsung_tv"))
                .body("order.price", Matchers.equalTo(200000))
                .body("order.quantity", Matchers.equalTo(5));

    }

}
