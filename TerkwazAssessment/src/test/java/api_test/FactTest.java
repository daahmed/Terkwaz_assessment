package api_test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FactTest {

	private Response res = null; // Response object
	private JsonPath jp = null; // JsonPath object
	private String json;

	/*
	 * navigate the https://cat-fact.herokuapp.com/facts/random with parameter
	 * animal_type and amount to get random cat fact
	 */
	@Before
	public void getRandomCatFate() {
		// Test Setup
		res = given().queryParam("animal_type", "cat").queryParam("amount", 1).when()
				.get("https://cat-fact.herokuapp.com/facts/random");

		json = res.asString();
		jp = new JsonPath(json);
	}

	/*
	 * then check the text field in not empty
	 */
	@Test
	public void checkTextFieldInResponsIsNotEmpty() {

		assertTrue(!jp.get("text").toString().isEmpty());
	}

}
