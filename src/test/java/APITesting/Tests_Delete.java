package APITesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Tests_Delete {
	
	@Test
	public void test_Delete() {
		
		baseURI = "http://localhost:3000";
		
		given().
		delete("users/4").then().statusCode(200).log().all();
				
		
		
	}

}
