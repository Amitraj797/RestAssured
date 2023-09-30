package RestassuredWithBDD;

import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Get {
	
	@Test
	public void fetch()
	{
	
//		given().body(job).contentType(ContentType.JSON)
		when().get("https://reqres.in/api/users/2")
		.then().assertThat().statusCode(200)
		.time(Matchers.lessThan(20000l),TimeUnit.MILLISECONDS)
		.log().all();
	}

}
