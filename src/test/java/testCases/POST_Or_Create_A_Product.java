package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;  // write manually

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class POST_Or_Create_A_Product {
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void create_A_Product() {
		
//		https://techfios.com/api-prod/api/product/create.php
		
		HashMap payload = new HashMap();
	
		payload.put("name", "iPhone NG 20");
		payload.put("description", "NextG Robotic Phone");
		payload.put("price", "3999");
		payload.put("category_id", "2");
		payload.put("category_name", "Electronics");
		
		Response response=
		
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type","application/json; charset=UTF-8")
			.body(payload)
			
		.when()
			.post("/create.php")
			
		.then()
			.extract().response();
		
//		String responseBody = response.getBody().asString();
		String responseBody = response.getBody().prettyPrint();
		System.out.println("ResponseBody: " + responseBody);
		
		String responseHeader = response.header("Content-Type");
		System.out.println("Print ResponseHeader Type : " + responseHeader);
		
	// Parsing responseBody to Json:
		JsonPath js = new JsonPath(responseBody);
		
		String message = js.getString("message");
		Assert.assertEquals(message, "Product was created.");

		int statusCode = response.getStatusCode();
		System.out.println("Print Status Code  " + statusCode);
		
		Assert.assertEquals(statusCode, 201); //hardAssert
//		softAssert.assertEquals(statusCode, 201); // softAssert
		
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response Time " +  responseTime);
		
		if(responseTime<=1000) {
			System.out.println("Response Time Is Within The Time");
			
		}else {
			System.out.println("Not Acceptable!!!");
		
		}
		
	}
	
}

