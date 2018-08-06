package com.testClasses;


import org.cts.hybrid.ExtentReports.ExtentTestManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Core.BaseAssertion;
import com.Core.RESTCalls;
import com.aventstack.extentreports.Status;
import com.utils.PayloadGenerator;
import com.utils.TestUtils;
import com.utils.URL;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test001 {
	

	Response response;
	String endPointUrl;
			
	@BeforeMethod
	public void generateAuth() {
		
	}
	
	@Test
	public void testGet() {
			
	//	ExtentTestManager.getTest().log(Status.INFO, "Get Test Started");
		
		endPointUrl = URL.getEndPoint();
		
		response = RESTCalls.GETRequest(endPointUrl);	
		
		BaseAssertion.verifyStatusCode(response, 200);
				
		System.out.println("*****************GET REQUEST COMPLETE*******************");
		
		String extractedResponse = TestUtils.getResposeString(response);
		
		JsonPath jsonObject = TestUtils.jsonParser(extractedResponse); 
		
		System.out.println(" " +jsonObject.get("$"));
		
	//	ExtentTestManager.endTest();
		
	}
	
//	@Test
	public void testPost() {
		
		String payload = PayloadGenerator.generatePayLoadString("Post.json");
		endPointUrl = URL.getEndPoint();
		
		response = RESTCalls.POSTRequest(endPointUrl, payload);	
		System.out.println("POST RESPONSE "+ response.asString());
		BaseAssertion.verifyStatusCode(response, 201);
		
		System.out.println("*****************POST REQUEST COMPLETE*******************");
	}
	
//	@Test
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