package APIAutoMation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FailingTests {
	
	
	@Test(description = "Wrong URL")
	void getalldata()
	{
		
		
			
			given()
		
		
			.when()
			.get("https://data.calgary.ca/resources/crbp-innf.json")  // Wrong URI
								
			
			.then()
			.statusCode(200);
		
	
	}
	
	
@Test (description = "Wrong Comparative Parameters")
	void getconditionaldata()
	{
	
	RestAssured.baseURI = "https://data.calgary.ca";
	//RestAssured.basePath = "/resource/crbp-innf.json?";
	
			//RequestSpecification Request = 
					
			Response response = given().contentType(ContentType.JSON).log().all()
					.get("/resource/crbp-innf.json?site_id=0020007253236&total_consumption=0");
					
			
			response.prettyPrint();
			
			JsonPath extractor = response.jsonPath();
			
			String unit = extractor.getString("unit");
			String consumption = extractor.getString("total_consumption");
			String site_id = extractor.getString("site_id");
			String year = extractor.getString("year");
			String month = extractor.getString("month");
			String Energy_consumption = extractor.getString("energy_description");
			String business_unit_desc = extractor.getString("business_unit_desc");
			
			
	/*		String resbody = response.getBody().asString();
			
			System.out.println("Response body is " + resbody); */
			
			int statuscode = response.statusCode();
			
			
			
			Assert.assertEquals(statuscode,201);
			Assert.assertEquals(unit,"[kWh]");
			Assert.assertEquals(consumption,"[0]");
			Assert.assertEquals(site_id,"[0020007253236]");
			Assert.assertEquals(year,"[2016]");
			Assert.assertEquals(month,"[Mar]");
			Assert.assertEquals(Energy_consumption,"[Electricity]");
			Assert.assertEquals(business_unit_desc,"[Calgary Housing]");
			
			
			
	}
	
	
	
	

}
