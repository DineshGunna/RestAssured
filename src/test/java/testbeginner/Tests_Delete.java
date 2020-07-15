package testbeginner;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Tests_Delete {
	
	@Test
	public void test_delete(){
		
		given().
		delete("https://reqres.in/api/users/2").
		then().
		statusCode(204).
		log().all();
		
		
	}

}
