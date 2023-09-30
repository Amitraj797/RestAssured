package RestAssuredWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get {
	@Test
	public void get()
	{
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		int statuscode=res.getStatusCode();
		
		Assert.assertEquals(200, statuscode);
		System.out.println(res.prettyPrint()); //TO print the reaponse 2 time in console.
//		System.out.println(res.prettyPeek());// TO print the response 1 time in console.
//		System.out.println(res.toString());// To print the response in 1 line in the console.
	}

}
