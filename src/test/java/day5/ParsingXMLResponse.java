package day5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ParsingXMLResponse {
    @Test
	void testXMLResponse() {
		//Approch without returning data
    	given()
    	  
    	.when()
    	  .get()
    	.then();
		
	}
}
