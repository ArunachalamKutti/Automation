package day1;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.security.PublicKey;

import org.testng.annotations.Test;

public class GetStatus {

	@Test(enabled = true, priority = 2)
	public void getDetails() {
		RestAssured.baseURI = "https://reqres.in/";

		RequestSpecification requestSpecification = RestAssured.given();

		Response response = requestSpecification.request(Method.GET, "/api/users?page=2");

		System.out.println(response.getStatusLine());

		System.out.println(response.asPrettyString());
	}

//		
	@Test(priority = 1)
	public void createEmployee() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		RequestSpecification requestSpecification2 = RestAssured.given();
		
		Response response2 = requestSpecification2.request(Method.POST,"{\r\n"
				+ "    \"name\": \"kutti\",\r\n"
				+ "    \"job\": \"arun\"\r\n"
				+ "}");
		
		System.out.println(response2.getStatusLine());
		
		System.out.println(response2.asPrettyString());
		System.err.println(response2.getStatusLine());
	}
	

}
