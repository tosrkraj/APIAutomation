package APIAutoMation;
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

public class GetConditionaldata 
{

	@Test
	
	void getconditionaldata()
	{
	
		
		given()
	
	
		.when()
		
			.get("https://data.calgary.ca/resource/crbp-innf.json?site_id=0020007253236&total_consumption=0")
				
		.then()
			.statusCode(200)
			.body("unit.toString()",equalTo("kWh"))
			.body("total_consumption",contains("0"))
			.log().all();
				
	}

	
}
