package day1;

import java.lang.annotation.Retention;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PetStore {
	
	@Test
	public void getListUserData()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		RequestSpecification requestSpecification = RestAssured.given();
		
		Response response = requestSpecification.request(Method.GET,"/api/users?page=1");
		
		System.out.println(response.getStatusLine());
		
		System.out.println(response.asPrettyString());
	}
	
	@Test
	public void getSingleUserData()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		RequestSpecification requestSpecification = RestAssured.given();
		
		Response response = requestSpecification.request(Method.GET,"/api/users/2");
		
		System.out.println(response.getStatusLine());
		
		System.out.println(response.asPrettyString());
	}
	
	
	@Test
	public void userNotFound()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		RequestSpecification requestSpecification = RestAssured.given();
		Response response = requestSpecification.request(Method.GET,"/api/users/23");
		
		System.out.println(response.getStatusLine());
		System.out.println(response.asPrettyString());
	}
	
	
	
	@Test
	public void createData()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		RequestSpecification requestSpecification = RestAssured.
				given().
				header("Content-Type","application/json").
				body("{\r\n"
				+ "    \"name\": \"kutti\",\r\n"
				+ "    \"job\": \"arun\"\r\n"
				+ "}");
		
		Response response = requestSpecification.request(Method.POST,"/api/users");
		
		
		System.out.println(response.getStatusLine());
		System.out.println(response.asPrettyString());
	}
	
	
	@Test(enabled = true)
	public void puData()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		RequestSpecification requestSpecification = RestAssured.
				given().
				header("Content-Type","application/json").
				body("{\r\n"
						+ "    \"name\": \"maha\",\r\n"
						+ "    \"job\": \"raja\"\r\n"
						+ "}");
		Response response = requestSpecification.request(Method.PUT,"api/users/202");
		
		System.out.println(response.getStatusLine());
		System.out.print(response.asPrettyString());
	}
	
	@Test(enabled = false)
	public void viewUpdatedData()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		RequestSpecification requestSpecification = RestAssured.given();
		
		Response response = requestSpecification.request(Method.GET,"api/users/202");
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());
	}
	
	
	
	@Test
	public void deleteUser()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		RequestSpecification requestSpecification = RestAssured.given();
		
		Response response = requestSpecification.request(Method.DELETE,"/api/users/2");
		
		System.out.println(response.getStatusLine());
		System.out.println(response.asPrettyString());
	}

}
