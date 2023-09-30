package Path_Parameter;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PathParameter {
	
	@Test
	public void create()
	{
		baseURI="https://api.github.com";
		Random r=new Random();
		int random = r.nextInt(100);
		String repo = "Lucifer"+random;
		JSONObject job=new JSONObject();
		job.put("name",repo);
		job.put("description", "Looking For Job");
		
		Response res = given().auth().oauth2("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").body(job).contentType(ContentType.JSON)
		.when().post("/user/repos");
		
		String reponame = res.jsonPath().get("name");
		
		given().pathParam("name", reponame).auth().oauth2("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")
		.when().get("/repos/amitraj797/{name}")
		.then().log().all();
		
	}

}
