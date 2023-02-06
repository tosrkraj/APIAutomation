package APIAutoMation;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

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

public class GetAllDataTest 
{

	
	
	
	@Test
	
	void getalldata()
	{
		
		
			
		given()
		
		
			.when()
			.get("https://data.calgary.ca/resource/crbp-innf.json")
								
			
			.then()
			.statusCode(200);
		//	.log().all();
	
	}

	
}
