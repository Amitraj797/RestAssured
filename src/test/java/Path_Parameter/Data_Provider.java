package Path_Parameter;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Data_Provider {
	
	@Test(dataProvider="data")
	public void create(String repo,String descrp)
	{
		baseURI="https://api.github.com";
		/*Random r=new Random();
		int random = r.nextInt(100);
		String repo = "Lucifer"+random;*/
		JSONObject job=new JSONObject();
		job.put("name",repo);
		job.put("description", descrp);
		
		Response res = given().auth().oauth2("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").body(job).contentType(ContentType.JSON)
		.when().post("/user/repos");
		
		String reponame = res.jsonPath().get("name");
		
		given().pathParam("name", reponame).auth().oauth2("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")
		.when().get("/repos/amitraj797/{name}")
		.then().log().all();
		
	}
	@DataProvider
	public Object[][] data()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="name";
		data[0][1]="description";
		data[1][0]="Lucifer1";
		data[1][1]=	"SDET";	
		
		return data;
	}

}
