package Response_Validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Response_Validation {

	
	@Test
  public void create()
  {
	
	  Random r=new Random();
	  int random = r.nextInt(1000);
	  String repo = "Test"+random;
			  
	  baseURI="https://api.github.com";
		
	  JSONObject job=new JSONObject();
	  job.put("name", repo);
	  job.put("description", "ASTE");
		
	  Response res = given().auth().oauth2("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").body(job).contentType(ContentType.JSON)
	  .when().post("/user/repos");
	  
	  String reponame=res.jsonPath().get("name");
	  System.out.println(reponame);
	  Assert.assertEquals(reponame, repo);
	  System.out.println("Pass");
	  res.then().log().all();
  }
}
