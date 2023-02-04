package APIAutoMation;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;




/*
given()
content type, set cookies, add auth, add param, set headers, basically prerequistes
when()

get, post, put,delete

then()
validations 

*/

public class RecordCount {

    
	@Test
	public static void totalrecords() {
        RestAssured.defaultParser = Parser.JSON;

  
        Response response = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                when().get("https://data.calgary.ca/resource/crbp-innf.json").
                then().contentType(ContentType.JSON).extract().response();
  
     
        List<String> jsonResponse = response.jsonPath().getList("$");

        System.out.println("Total Number of Records : " + jsonResponse.size());
    }
}


