package dataDrivenTesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class Tests_Post extends DataForTests {
	
		
	@Test(dataProvider = "PostData")
	public void test_Post(String firstName, String lastName, int subjectId) {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName",firstName);
		request.put("lastName",lastName);
		request.put("subjectId",subjectId);
		
		baseURI = "http://localhost:3000";
		
		given().header("Content-Type","application/json").
		contentType(ContentType.JSON)
		.accept(ContentType.JSON).
		body(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();
		
		
		
	}

}
