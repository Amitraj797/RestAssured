package post_Using_File;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Post {

//	USING RESTASSURED WITH FILE

	
	
	@Test
	public void create()
	{
		baseURI="https://reqres.in";
		File f=new File("./src/test/resources/Resource.json");
		given().body(f).contentType(ContentType.JSON)
		.when().post("/api/users")	
		.then().assertThat().statusCode(201)
		.time(Matchers.lessThan(20000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}
