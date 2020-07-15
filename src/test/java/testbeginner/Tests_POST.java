package testbeginner;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Tests_POST {
	
	@Test
	public void test_post()
	{
		
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("first_name","Dinesh");
//		map.put("last_name","Gunna");
//		System.out.println(map);
//		
//		JSONObject request = new JSONObject(map);
//		System.out.println(request);
//		System.out.println(request.toJSONString());
		
		JSONObject req = new JSONObject();
		req.put("id","10");
		req.put("email","dinesh.gunna5@gmail.com");
		req.put("first_name","Dinesh");
		req.put("last_name","Gunna");
		req.put("avatar","https://s3.amazonaws.town");


		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(req.toJSONString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log().all();
		
	}
}
