package RestassuredWithBDD;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Post {
	
//	USING RESTASSURED WITH BDD

	@Test
	public void create()
	{
//		To Create the body
		JSONObject job=new JSONObject();
		job.put("name", "Amit");
		job.put("job", "Software Tester");
		
		
		given().body(job).contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then().assertThat().statusCode(201)
		.time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS)
		.log().all();
		
	}
}
