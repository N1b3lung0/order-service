package com.n1b3lung0.order;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {

	@ServiceConnection
	static PostgreSQLContainer<?> postgreSQLContainer;
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

    static {
        postgreSQLContainer = new PostgreSQLContainer<>("postgres:16.3-alpine");
        postgreSQLContainer.start();
    }

	@Test
	void contextLoads() {
	}

	@Test
	void shouldSubmitOrder() {
		String submitOrderJson = """
                {
                     "skuCode": "iphone_15",
                     "price": 1000,
                     "quantity": 1
                }
                """;


		String location = RestAssured.given()
				.contentType("application/json")
				.body(submitOrderJson)
				.when()
				.put("/orders")
				.then()
				.statusCode(HttpStatus.SC_CREATED)
				.body(Matchers.blankString())
				.extract().header("location");

		System.out.println(location);
	}

}
