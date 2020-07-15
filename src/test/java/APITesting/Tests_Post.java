package APITesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Tests_Post {
	
	@Test
	public void test_Post() {
		
		
		JSONObject request = new JSONObject();
		
		request.put("firstName","Tom");
		request.put("lastName","Cruise");
		request.put("subjectId",2);
		
	
//		request.put("name","Ruby");
		
		
		
		baseURI =  "http://localhost:3000";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();
	}

}
