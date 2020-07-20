package jsonschema;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import configurations.Endpoints;
import configurations.RestAssuredConfiguration;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;



public class JSONSchemaValidator {

	@Test
	public void jsonSchemaValidator() {
		//baseURI = "https://jsonplaceholder.typicode.com/";
		
		given().when()
		.get("https://jsonplaceholder.typicode.com/comments?postId=1")
		.then()
		.assertThat()
		.body(matchesJsonSchemaInClasspath("Posts.json"));
		
//		RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
//		requestSpecification.queryParam("postId,1");
//		Response response = new RestAssuredConfiguration().getResponse(requestSpecification, Endpoints.Schema_endpoint, HttpStatus.SC_OK);
//		String responseBody = response.getBody().asString();
//		SoftAssert softassert = new SoftAssert();
//		softassert.assertThat(responseBody,matchesJsonSchemaInClasspath("Posts.json"));
		
		
	}
	
}
