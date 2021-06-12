package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;  // write manually

import java.util.concurrent.TimeUnit;

public class GET_Or_Read_A_Product {
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void read_A_Product() {
//	public void read_A_Product(String queryIdValue)	// Remove the Parameter if we read the exiting product
//		https://techfios.com/api-prod/api/product/read_one.php?id=1638
		
		Response response=
		
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type","application/json")
			.queryParam("id", "1630")
			
		.when()
			.get("/read_one.php")
			
		.then()
			.extract().response();
		
		String responseBody = response.getBody().asString();
		System.out.println("Print ResponseBody: " + responseBody);
		response.getBody().prettyPrint();
//		String responseContenType = response.header("Content-Type");
//		System.out.println("Print ResponseHeader Type : " + responseHeader);
//		softAssert.assertEquals(responseContenType, "application/json", "Header Missmatch");
//	
//	 //Parsing responseBody to Json:
//		JsonPath js = new JsonPath(responseBody);
//		
//		String productId = js.getString("id");
//		String productName = js.getString("name");
//		String productDescription = js.getString("description");
//		
//		Assert.assertEquals(productId, "445");
//		Assert.assertEquals(productName, "SELENIUM BOOK");
//		Assert.assertEquals(productDescription, "ALL SELENIUM  EXAMPLES");
//		
//		softAssert.assertEquals(productId, "445", "ProductId Missmatch!!!");
//		softAssert.assertEquals(productName, "SELENIUM BOO", "ProductName Missmatch!!!");
//		softAssert.assertEquals(productDescription, "ALL SELENIUM  EXAMPLES", "ProductDescription Missmatch!!!");
//		
//		softAssert.assertAll();  // This Assertion will tell me the console details if any softAssert will fail
//		
		
		
//		int statusCode = response.getStatusCode();
//		System.out.println("Print Status Code  " + statusCode);
//		
//		Assert.assertEquals(statusCode, 201); //hardAssert
//		softAssert.assertEquals(statusCode, 201); // softAssert
//		
//		String responseBody = response.getBody().prettyPrint();
//		String responseBody = response.getBody().asString();
//		System.out.println("ResponseBody: " + responseBody);
//		
//		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
//		System.out.println("Response Time " +  responseTime);
//		
//		
//		if(responseTime<=1000) {
//			System.out.println("Response Time Is Within The Time");
//			
//		}else {
//			System.out.println("Not Acceptable!!!");
//			
			
		}
		
	}
	


