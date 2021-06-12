package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;  // write manually

public class GET_Or_Read_All_Products {
	
	@Test
	public void read_All_Products() {
		
//		https://techfios.com/api-prod/api/product/read.php
		Response response=
		
		given()
		//	.log().all()
			.log().uri()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type","application/json; charset=UTF-8")
		.when()
			//.log().all()
			.get("/read.php")
		.then()
			.log().all()
			.log().status()
			.statusCode(200) //Validate purpose
			.header("Server", "Apache") //Validate purpose
			.header("Content-Type", "application/json; charset=UTF-8") //Validate purpose
			
			.extract().response();
		
		int statusCode = response.getStatusCode();
		System.out.println("Print Status Code  " + statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		
	}
	

}
