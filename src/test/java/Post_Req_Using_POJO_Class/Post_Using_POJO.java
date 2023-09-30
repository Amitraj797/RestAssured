package Post_Req_Using_POJO_Class;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Object_Repository.Pojo;
import io.restassured.http.ContentType;

public class Post_Using_POJO {

	
	@Test
	public void create()
	{
		Pojo p=new Pojo("Amit", "ATE");
		given().body(p).contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then().assertThat().statusCode(201)
		.log().all();
	}
}
