package APIAutoMation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
given()
content type, set cookies, add auth, add param, set headers, basically prerequistes
when()

get, post, put,delete

then()
validations 

*/

public class GetConditionaldataTest 
{

	@Test
	
	public void getconditionaldata()
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
			
			
			
			AssertJUnit.assertEquals(statuscode,200);
			AssertJUnit.assertEquals(unit,"[kWh]");
			AssertJUnit.assertEquals(consumption,"[0]");
			AssertJUnit.assertEquals(site_id,"[0020007253236]");
			AssertJUnit.assertEquals(year,"[2016]");
			AssertJUnit.assertEquals(month,"[Mar]");
			AssertJUnit.assertEquals(Energy_consumption,"[Electricity]");
			AssertJUnit.assertEquals(business_unit_desc,"[Calgary Housing]");
	}
	
	
	
	@Test
	@DataProvider(name="Datausingexcel")
	public Object[][] testdata()
	{
		return null;
		
		
		
	}
	
	

	
}
