package APIAutoMation;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;

import io.restassured.http.Header;
import io.restassured.http.Headers;
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
	
public	void getalldata()
	{
		
		
			
		given()
		
		
			.when()
			.get("https://data.calgary.ca/resource/crbp-innf.json")
								
			
			.then()
			.statusCode(200);
		
	
	}

@Test
	public void headerstest()
	{
		Response response = given()
		
		.when()
		.get("https://data.calgary.ca/resource/crbp-innf.json");
		
		Headers AllHead = response.headers();
		
		
		System.out.println("Response time "+ response.getTime());
		
		for(Header header:AllHead)
		{
			System.out.println("Header Name "+header.getName() + "  " +header.getValue());
			
		}
		
	}
}
