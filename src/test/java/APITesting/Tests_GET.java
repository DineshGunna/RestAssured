package APITesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Tests_GET {
	
	@Test
	public void test_Get() {
		
		baseURI = "http://localhost:3000";
		given().
//		param("lastName", "Gunna").
//		get("/users").
		param("name", "Automation").
		get("/subjects").
		then().
		statusCode(200).
		log().
		all();
		
	}

	
	
}
