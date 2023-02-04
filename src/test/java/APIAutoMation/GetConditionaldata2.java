package APIAutoMation;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

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

public class GetConditionaldata2 
{

	@Test
	
	void getconditionaldata()
	{
	
		 RestAssured.defaultParser = Parser.JSON;

		  
	        given()
	        	.headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON);
	        when()
	        	.get("https://data.calgary.ca/resource/crbp-innf.json?site_id=0020007253236&total_consumption=0")
	                
	        .then()
	            	.contentType(ContentType.JSON)
	            	.statusCode(200)
	    			.body("unit",equalTo("kWh"))
	    			.body("total_consumption",contains("0"))
	    			.log().all();
				
	        
	}

	
}
