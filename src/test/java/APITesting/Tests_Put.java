package APITesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Tests_Put {
	
	@Test
	public void test_Put(){
		

		JSONObject request = new JSONObject();
		
		request.put("firstName","Dwayne");
		request.put("lastName","Johnson");
		request.put("subjectId",2);
		
		
		baseURI =  "http://localhost:3000";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("/users/6").
		then().
		statusCode(200).
		log().all();
		
	}

}
