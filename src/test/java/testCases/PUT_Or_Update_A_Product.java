package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;  // write manually

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class PUT_Or_Update_A_Product {
	
	SoftAssert softAssert = new SoftAssert();
	
	GET_Or_Read_A_Product readAproduct = new GET_Or_Read_A_Product();
	
	@Test
	public void update_A_Product() {
		
//		https://techfios.com/api-prod/api/product/update.php
		
		HashMap payload = new HashMap();
		payload.put("id", "1638");
		payload.put("name", "iPhone NG 21");
		payload.put("description", "NextG SuperSonic Robotic Phone");
		payload.put("price", "8999");
		payload.put("category_id", "2");
		payload.put("category_name", "Electronics");
		
		Response response=
		
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type","application/json; charset=UTF-8")
			.body(payload)
			
		.when()
			.put("/update.php")
			
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
		//Assert.assertEquals(message, "Product was updated.");
		softAssert.assertEquals(message, "Product was updated.");
		
//		readAproduct.read_A_Product("1638"); 
		readAproduct.read_A_Product();  // If we read a exiting delete product we should not need String Parameter
		int statusCode = response.getStatusCode();
		System.out.println("Print Status Code  " + statusCode);
		
		Assert.assertEquals(statusCode, 200); //hardAssert
//		softAssert.assertEquals(statusCode, 200); // softAssert
		
		softAssert.assertAll();
	
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response Time " +  responseTime);
		
		if(responseTime<=1000) {
			System.out.println("Response Time Is Within The Time");
			
		}else {
			System.out.println("Not Acceptable!!!");
			
			
		}
		
	}
	
}

