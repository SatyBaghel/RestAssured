package basicsofapi;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderDemo {
	
	//@Test
 void testHeaders() {
		
		given()
		
		.when()
		   .get("https://www.google.co.in/")
		.then()
		   .header("Content-Type","text/html; charset=ISO-8859-1")
		   .header("Content-Encoding","gzip")
		   .header("Server", "gws");
		  // .log().all();
 }
		@Test
		 void testAllHeaders() {
				
				Response res = given()
								.when()
				                   .get("https://www.google.co.in/");
				//get single header
				String headervalue = res.header("Content-Type");
				//System.out.println(headervalue);
				
				//get All header info
			Headers	myheader = res.headers();
			
			for(Header hd:myheader)
			{
				System.out.println(hd.getName()+"  "+hd.getValue());
				
			}
				
				
				
	 
 }
}
