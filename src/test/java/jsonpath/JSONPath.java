package jsonpath;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class JSONPath {
	
	@Test
	public void acquireJsonPath(){
		
		baseURI = "https://reqres.in";
		
		String response = given().when().get("/api/users?page=2").thenReturn().asString();
		System.out.println(response);
		
		JsonPath json = new JsonPath(response);
		System.out.println(json);
		
	Assert.assertEquals(7,json.getInt("data[0].id"));
	Assert.assertEquals("tobias.funke@reqres.in",json.getString("data[2].email"));
	Assert.assertEquals("Lindsay",json.getString("data[1].first_name"));
	Assert.assertEquals("StatusCode Weekly",json.getString("ad.company"));

	}

}
