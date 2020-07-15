package APITesting;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Tests_Patch {

	@Test
	public void test_Put(){
		

		JSONObject request = new JSONObject();
		
	
		request.put("lastName","Narayana");
		
		
		
		baseURI =  "http://localhost:3000";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("/users/2").
		then().
		statusCode(200).
		log().all();
		
	}
	
}
