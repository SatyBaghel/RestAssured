package basicsofapi;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class LoggingDemo {

	@Test
	void testLogMethod() {
		
		given()
		
		.when()
		    //.get("https://www.google.co.in/")
		      .get("https://reqres.in/api/users?page=2&id=5")
		
		.then()
		//  .log().status();
		    //.log().body();
		     .log().headers();
		    
		
		 
	}
}
