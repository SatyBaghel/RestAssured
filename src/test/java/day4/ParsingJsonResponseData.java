package day4;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJsonResponseData {

	//@Test
	void testJsonObjectBody() {
		//Approch 1
		given()
		  .contentType("ContentType.json")
		.when()
		   .get("http://localhost:3000/book")
		
		.then()
		  .statusCode(200)
		  .header("Content-Type", "application/json")
		  //.body("book[1].title",equalTo("Sword of honour"));
		  .body("book[2].title", equalTo("Moby Dick"));
			}
	
	//Approcha 2
	@Test
		void testJsonObjectBody2() {
			
			Response res = given()
			  .contentType(ContentType.JSON)
			.when()
			   .get("http://localhost:3000/book");
		/*	
			Assert.assertEquals(res.getStatusCode(), 200);//Validation 1
			Assert.assertEquals(res.header("Content-Type"), "application/json");
			String bookname = res.jsonPath().get("book[2].title").toString();
			Assert.assertEquals(bookname, "Moby Dick");*/
			
			//JSONObject Class
			JSONObject jo = new JSONObject(res.toString());//convert response to json array
			/*for(int i=0;i<jo.getJSONArray("book").length();i++)
			{
				String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
				System.out.println(bookTitle);
							}*/
			boolean status = false;
			for(int i=0;i<jo.getJSONArray("book").length();i++)
			{
				String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
				if(bookTitle.equals("Sword of honour")) {
					status = true;
				}
				
			}
			Assert.assertEquals(status, true);
			
			
			
				}
}
