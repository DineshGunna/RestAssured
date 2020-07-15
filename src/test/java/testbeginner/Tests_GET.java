package testbeginner;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Tests_GET {
	
	
	@Test
	public void test_get() {
		
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.last_name[5]", equalTo("Howell"))
		.log().all();
		
		
	}
	
}
