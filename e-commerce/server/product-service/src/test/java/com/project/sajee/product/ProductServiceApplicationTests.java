package com.project.sajee.product;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // set random port to ignore conflict
class ProductServiceApplicationTests {

    @LocalServerPort
    private Integer localPort;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = localPort;

    }

    @Test
    void shouldCreateNewProduct() {
        String productJson = """
                {
                    "name": "TV-Samsung",
                    "description": "Smart LED TV, 55 inch width",
                    "price": 155000
                }
                """;
        RestAssured
                .given()
                .contentType("application/json")
                .body(productJson)
                .when()
                .post("/api/v1.0/product/add")
                .then()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo("TV-Samsung"))
                .body("description", Matchers.equalTo("Smart LED TV, 55 inch width"))
                .body("price", Matchers.equalTo(155000));

    }

    @Test
    void contextLoads() {
    }

}
