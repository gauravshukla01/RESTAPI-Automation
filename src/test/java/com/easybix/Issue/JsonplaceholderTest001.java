package com.easybix.Issue;

import org.testng.annotations.Test;

import com.easybix.RestAssuredCore.BaseAssertion;
import com.easybix.RestAssuredCore.RESTCalls;
import com.easybix.utils.URL;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;


public class JsonplaceholderTest001 {
	
	Response response;
	String endPointUrl;
	

	@Test
	public void validateGetRequest() {
		
		endPointUrl = URL.getEndPoint();
		
		response = RESTCalls.GETRequest(endPointUrl);
	
		BaseAssertion.verifyStatusCode(response, 200);
		
		System.out.println(response.asString());
	}
	
//	@Test 
	public void test() {
	
		RestAssured.proxy("proxy.cognizant.com", 6050);
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		given().
		 param("location", "-33.8670522,151.1957362").
		 param("radius", "500").
		 param("type", "restaurant").
		 param("key", "AIzaSyB-ZliaFkPtyfykn7E2nW2yxgBPAvRVUMo").
		 when().
		 get("/maps/api/place/nearbysearch/json").
		 then().assertThat().statusCode(200).and().
		 contentType(ContentType.JSON);
		
		/*.and().
		 body("results[0].name", equalTo("The Little Snail Restaurant")).and().
		 body("results[13].name", equalTo("Harvest Buffet")).and().
		 body("results[5].vicinity", equalTo("80 Pyrmont Street, Pyrmont")).and().
		 header("server", "pablo");*/
		
		System.out.println("Request is " );
	}
}

