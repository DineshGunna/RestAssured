package testbeginner;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Tests_PUT {
	
	@Test
	public void test_put() {
		
		JSONObject request = new JSONObject();
		
		request.put("id","10");
		request.put("email","dileepgunna9@gmail.com");
		request.put("first_name","Dileep");
		request.put("last_name","Gunna");
		request.put("avatar","data:image/jpeg;base64,cWFVSJHorACxYsUIf/9k=");
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		log().
		all();
		
		
	}

}
