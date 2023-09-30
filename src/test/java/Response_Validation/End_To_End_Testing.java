package Response_Validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class End_To_End_Testing {
	
	@Test
	public void endToEnd()
	{
//			FOR CREATING THE REPO
		  Random r=new Random();
		  int random = r.nextInt(1000);
		  String repo = "Test"+random;
				  
		  baseURI="https://api.github.com";
			
		  JSONObject job=new JSONObject();
		  job.put("name", repo);
		  job.put("description", "ASTE");
			
		  Response res = given().auth().oauth2("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").body(job).contentType(ContentType.JSON)
		  .when().post("/user/repos");
		 
//		  FOR GETTING THE DETAIL OF REPO
		  String reponame=res.jsonPath().get("name");
//		  System.out.println(reponame);
//		  Assert.assertEquals(reponame, repo);
//		  System.out.println("Pass");
//		  res.then().log().all();
		  
		  given().auth().oauth2("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").when().get("/repos/amitraj797/"+reponame)// CODE for Fetching the details
		  .then().log().all();
		  
//		  FOR Update the REPO
		  
		  job.put("description", "Test Engineer");
		  
		  given().auth().oauth2("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").body(job).contentType(ContentType.JSON)
		  .when().patch("/repos/amitraj797/"+reponame)
		  .then().log().all();
		  
//		  FOR Delete the Repo
		  given().auth().oauth2("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").when().delete("/repos/amitraj797/"+reponame)
		  .then().log().all();
	}

}
