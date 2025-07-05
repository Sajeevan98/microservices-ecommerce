package com.project.sajee.inventory;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // avoid port conflict
class InventoryServiceApplicationTests {

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	@Test
	void shouldCheckInventoryForPositive(){
		var response = RestAssured
				.given()
				.get("api/v1.0/inventory?code=samsung_tv&quantity=5")
				.then()
				.log().all()
				.statusCode(200)
				.extract().response()
				.as(Boolean.class);
		assertTrue(response);
	}
	@Test
	void shouldCheckInventoryForNegative(){
		var response = RestAssured
				.given()
				.get("api/v1.0/inventory?code=samsung_tv&quantity=500")
				.then()
				.log().all()
				.statusCode(200)
				.extract().response()
				.as(Boolean.class);
		assertFalse(response);
	}


}
