package RestAssuredWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Put {

	@Test
	public void patch()
	{
//		TO Create the body we are using JSONObject ,we can use HashMap also.
		JSONObject job=new JSONObject();
		job.put("name", "Raj");
		job.put("job", "TestEngineer");
		
//		To change the content Type to jason
		RequestSpecification request = RestAssured.given();  // given is used for precondition.
		request.body(job).contentType(ContentType.JSON);
		
//		TO Get the response from the server.
		Response res = request.put("https://reqres.in/api/users/2");
		
		int statuscode = res.getStatusCode();
		Assert.assertEquals(200, statuscode);
		System.out.println(res.prettyPrint()); //TO print the reaponse 2 time in console.
//		System.out.println(res.prettyPeek());// TO print the response 1 time in console.
//		System.out.println(res.toString());// To print the response in 1 line in the console.
		
	}
}
