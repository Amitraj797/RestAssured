package RestassuredWithBDD;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Patch {

	@Test
	public void patch()
	{
		JSONObject job=new JSONObject();
		job.put("name", "Amit");
		
		
		
		given().body(job).contentType(ContentType.JSON)
		.when().patch("https://reqres.in/api/users/2")
		.then().assertThat().statusCode(200)
		.time(Matchers.lessThan(20000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}
