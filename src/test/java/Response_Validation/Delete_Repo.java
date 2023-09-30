package Response_Validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

public class Delete_Repo {

	@Test
	public void delete()
	{
		 
		  String reponame="Test199";
				  
		  baseURI="https://api.github.com";
		  
		  given().auth().oauth2("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").when().delete("/repos/amitraj797/"+reponame)
		  .then().log().all();
	}
}
