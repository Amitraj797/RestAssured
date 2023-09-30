package RestassuredWithBDD;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Put {

	@Test
	public void put()
	{
		JSONObject job=new JSONObject();
		job.put("name", "Sumit");
		job.put("job", "Automation");
		
		
		given().body(job).contentType(ContentType.JSON)
		.when().put("https://reqres.in/api/users/2")
		.then().assertThat().statusCode(200)
		.time(Matchers.lessThan(20000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}
