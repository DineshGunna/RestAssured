package dataDrivenTesting;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Tests_Delete extends DataForTests {

	//@Test(dataProvider = "DeleteData")
	public void test_Delete(int userid) {
		
		baseURI = "http://localhost:3000";
		
		given().delete("/users/" + userid).then().statusCode(200).log().all();
	}
	
	@Parameters({"userId"})
	@Test
	public void test_DeleteParameter(int userId) {
		
		baseURI = "http://localhost:3000";
		
		given().delete("/users/" + userId).then().statusCode(200).log().all();
	}
}
