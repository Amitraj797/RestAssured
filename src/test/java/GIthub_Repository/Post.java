package GIthub_Repository;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Post {
	
	@Test
	public void create()
	{
		baseURI="https://api.github.com";
		
		JSONObject job=new JSONObject();
		job.put("name", "Test");
		job.put("description", "ASTE");
		
		
		given().auth().oauth2("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").body(job).contentType(ContentType.JSON)
		.when().post("/user/repos")
		.then().log().all();
		
	}

}
