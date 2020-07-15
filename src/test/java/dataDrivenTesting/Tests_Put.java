package dataDrivenTesting;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class Tests_Put extends DataForTests {
	
	 
	@Test(dataProvider = "PutData")
	public void test_Put(String firstName, String lastName, int subjectId, int userid){
		

		JSONObject request = new JSONObject();
		
		request.put("firstName",firstName);
		request.put("lastName",lastName);
		request.put("subjectId",subjectId);
		
		
		baseURI =  "http://localhost:3000";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("/users/"+ userid).
		then().
		statusCode(200).
		log().all();
		
	}

}
