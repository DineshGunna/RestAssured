package responsevalidation;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ValidateResponse {
	
	
	@Test
	public void validateResponse() {
		baseURI = "http://localhost:3000/";
		Response response = given().get("students"); //Getting Response
	
		response.then()
		.statusCode(200)
		//Inline Validation
		//Hard Assertion
		.body("firstName[0]", equalTo("Dinesh")).body("lastName", hasItems("Gunna","Narayana","Buffet"))
		.body("subjectId[2]", equalTo(1)).body("lastName[3]", equalTo("Winden"))
		.log().all();
		//Soft Assertion
		given().get("subjects").then().statusCode(200).body("name", hasItems("Automation","Framework"),"name[3]", equalTo("Ruby"),"name[2]", equalTo("Framework")).log().all();
	
		//Path Validation
		//Hard Assertion
		Assert.assertEquals(response.path("firstName[0]"),"Dinesh","firstname not equal");
		Assert.assertEquals(response.path("lastName[0]"),"Gunna","lastname not equal");
		Assert.assertEquals(response.path("subjectId[1]"),1,"id not equal");
		//soft assertion
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(response.path("firstName[1]"),"Dinesh","firstname not equal");
		softassert.assertEquals(response.path("lastName[0]"),"Gunna","lastname not equal");
		softassert.assertEquals(response.path("subjectId[0]"),1,"id not equal");
		softassert.assertAll();
	
	}

}
