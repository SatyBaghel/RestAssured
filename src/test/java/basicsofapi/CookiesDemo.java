package basicsofapi;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {

	//@Test(priority =1)
	void testCookies() {
		
		given()
		  
		.when()
		  .get("https://www.google.co.in/")
		  
		.then()
		  .cookie("AEC", "AZ6Zc-WR6a4ElDJAGC2jOS4R3ilNMKUEFT2pe0cl6ydqWsq7UQKuuSsYvRw")//should fell bzc every time cookies value changes
		  .log().status();
			}
	@Test(priority =2)
	void testAllCookies() {
		
		Response res = given()
		  
		.when()
		  .get("https://www.google.co.in/");
		//get single value
		//String cookie_value = res.getCookie("AEC");
		//System.out.println("Cooke value ===>"+cookie_value);
		
		//multiple cookie value
		Map<String, String> cookies_value = res.getCookies();
		//System.out.println(cookies_value.keySet());
		
		for(String k:cookies_value.keySet()) 
		{
			String cookie_value  = res.getCookie(k);
			System.out.println(k+" =  "+cookie_value);
			
		}
		
		
		
		
	}
}
