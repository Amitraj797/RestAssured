package Post_Req_Using_Form_Parameter;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Post {

	
//	USING RESTASSURED WITH FORM PARAMETER

	
	
	@Test
	public void create()
	{
		baseURI="https://reqres.in";
		
		given().formParam("name", "amit").formParam("job", "Leader")
		.contentType(ContentType.JSON)
		.when().post("/api/users")
		.then().assertThat().statusCode(201)
		.time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}
