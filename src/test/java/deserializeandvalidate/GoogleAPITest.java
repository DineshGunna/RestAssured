package deserializeandvalidate;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.bin.Google;
import com.automation.bin.Item;
import com.automation.bin.VolumeInfo;

import configurations.*;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.util.List;

public class GoogleAPITest {

	@Test
	public void googleApiTest() {
		baseURI = "https://www.googleapis.com";
		RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
		requestSpecification.queryParam("q","turing");
		Response response =	new RestAssuredConfiguration().getResponse(requestSpecification,Endpoints.GOOGLE_API, HttpStatus.SC_OK);
		Google google = response.as(Google.class, ObjectMapperType.GSON);
		SoftAssert softassert = new SoftAssert();
		List<Item> items =  google.getItems();
		for(Item item:items) {
			softassert.assertTrue(!item.getId().equalsIgnoreCase(""),"ITEM ID IS BLANK");
			VolumeInfo volumeinfo = item.getVolumeInfo();
			softassert.assertTrue(!volumeinfo.getTitle().equalsIgnoreCase("edf"),"VOLUMEINFO TITLE  IS BLANK");

		}
		softassert.assertAll();
	}
	
	
	
}
