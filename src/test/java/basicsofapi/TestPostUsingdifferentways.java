package basicsofapi;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


 //Different ways to create Post request
/* post request body using Hashmap 
 * post request body creation  using org.json
 * post request body creation using POJO class
 * post request body creation using json file data
  */
public class TestPostUsingdifferentways {
	
	//@Test(priority=1)
	void testPostUsingHashmap() {

	HashMap data = new HashMap();
	
	data.put("name", "Scott");
	data.put("location", "France");
	data.put("phone", "123456");
	
	String courseArr[] = {"C", "C++"};
	data.put("courses", courseArr);
	
	given()
	    .contentType("application/json")
	    .body(data)
	    
	.when()
	    .post("http://localhost:3000/students")
	
	.then()
	    .statusCode(201)
	    .body("name", equalTo("Scott"))
	    .body("location", equalTo("France"))
	    .body("phone", equalTo("123456"))
	    .body("courses[0]", equalTo("C"))
	    .body("courses[1]", equalTo("C++"))
	    //.header("Content-Type", equalTo("application/json; charset=utf-8"))
	  	.log().all();
	}
	// 2) Post using Org.json
	//@Test(priority =1)
	void testPostUsingORGJson() {
		
		JSONObject data = new JSONObject();
		
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "123456");
		
		String courseArr[] = {"C", "C++"};
		data.put("courses", courseArr);
		
		given()
		    .contentType("application/json")
		    .body(data.toString())
		    
		.when()
		    .post("http://localhost:3000/students")
		
		.then()
		    .statusCode(201)
		    .body("name", equalTo("Scott"))
		    .body("location", equalTo("France"))
		    .body("phone", equalTo("123456"))
		    .body("courses[0]", equalTo("C"))
		    .body("courses[1]", equalTo("C++"))
		    //.header("Content-Type", equalTo("application/json; charset=utf-8"))
		  	.log().all();
	}
	// 3) Post request body using POJO(Plain old java object)
	//@Test(priority =1)
	void testPostRequestUsingPojo() {
		POJO_PostRequest data = new POJO_PostRequest();
		
		data.setName("Scott");
		data.setLocation("France");
		data.setPhone("123456");
		String courseArr[] = {"C", "C++"};
		data.setCourses(courseArr);
		
		given()
		    .contentType("application/json")
		    .body(data)
		    
		.when()
		    .post("http://localhost:3000/students")
		
		.then()
		    .statusCode(201)
		    .body("name", equalTo("Scott"))
		    .body("location", equalTo("France"))
		    .body("phone", equalTo("123456"))
		    .body("courses[0]", equalTo("C"))
		    .body("courses[1]", equalTo("C++"))
		    //.header("Content-Type", "application/json; charset=utf-8")
		  	.log().all();
	}
		
	//post request body using external file
	@Test(priority =1)
	void testPostUsingEternalFile() throws FileNotFoundException {
		
		File f = new File("C:\\Users\\hp\\Desktop\\Appium\\RestAssuredAPI\\body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		given()
	    .contentType("application/json")
	    .body(data)
	    
	.when()
	    .post("http://localhost:3000/students")
	
	.then()
	    .statusCode(201)
	    .body("name", equalTo("Scott"))
	    .body("location", equalTo("France"))
	    .body("phone", equalTo("123456"))
	    .body("courses[0]", equalTo("C"))
	    .body("courses[1]", equalTo("C++"))
	    //.header("Content-Type", "application/json; charset=utf-8")
	  	.log().all();
	}
	
	
	
	
	
	//Delete student record
	//@Test(priority=2)
	void testDelete() {
		
		given()
		
		.when()
		  .delete("http://localhost:3000/students/ca2e")
		  
		  .then()
		    .statusCode(200);
			}
	    
	    
	    
	    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
