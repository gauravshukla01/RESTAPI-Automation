package com.easybix.Issue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.easybix.RestAssuredCore.BaseAssertion;
import com.easybix.RestAssuredCore.RESTCalls;
import com.easybix.utils.PayloadGenerator;
import com.easybix.utils.URL;

import io.restassured.response.Response;

public class Test001 {
	
	Response response;
	String endPointUrl;
	
	@BeforeMethod
	public void generateAuth() {
		
	}
	
//	@Test
	public void testGet() {
		
		endPointUrl = URL.getEndPoint();
		
		response = RESTCalls.GETRequest(endPointUrl);	
		System.out.println("GET RESPONSE "+response.asString());
		BaseAssertion.verifyStatusCode(response, 200);
		System.out.println("*****************GET REQUEST COMPLETE*******************");
	}

//	@Test
	public void testPost() {
		
		String payload = PayloadGenerator.generatePayLoadString("Post.json");
		endPointUrl = URL.getEndPoint();
		
		response = RESTCalls.POSTRequest(endPointUrl, payload);	
		System.out.println("POST RESPONSE "+response.asString());
		BaseAssertion.verifyStatusCode(response, 201);
		
		System.out.println("*****************POST REQUEST COMPLETE*******************");
	}
	
	@Test
	public void testPut() {
		
		endPointUrl = URL.getEndPoint("100");
		String payload = PayloadGenerator.generatePayLoadString("Put.json");
		System.out.println(payload);
		response = RESTCalls.PUTRequest(endPointUrl, endPointUrl);	
		
		System.out.println("*****************PUT REQUEST COMPLETE*******************");
		
		System.out.println("GET RESPONSE "+response.asString());
		BaseAssertion.verifyStatusCode(response, 200);
	}
}

/*JsonPath json = new JsonPath(responseString);
int arraySize = json.getInt("results.size()");

for(int i=0;i < arraySize;i++){
	String name = json.getString("results["+i+"].name");
	System.out.println(name);
}*/

/*https://reqres.in/api/register

GET - https://reqres.in/api/users?page=2

Post - https://reqres.in/api/users

{
    "name": "morpheus",
    "job": "leader"
} */

