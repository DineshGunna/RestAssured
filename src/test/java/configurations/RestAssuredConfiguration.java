package configurations;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeSuite;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class RestAssuredConfiguration {
	
	@BeforeSuite
	public void configure() {
		
		 baseURI = "https://www.googleapis.com";
	}

	public RequestSpecification getRequestSpecification() {
		
		return given().contentType(ContentType.JSON);
	}
	
	public Response getResponse(RequestSpecification requestSpecification, String endpoint,int status) {
		
		Response response = requestSpecification.get(endpoint);
		Assert.assertEquals(response.getStatusCode(), status);
		response.then().log().all();
		return response;
	}
}
