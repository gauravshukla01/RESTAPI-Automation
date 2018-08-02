package com.Core;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.cts.hybrid.ExtentReports.ExtentTestManager;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.utils.TestUtils;

import io.restassured.response.Response;

public class BaseAssertion {
	private static Logger log = LogManager.getLogger(TestUtils.class.getName());
	
		
	public static void verifyTrue(boolean flag){
		Assert.assertTrue(flag);
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed Successfully");
	}
	
	public static void verifyFalse(boolean flag){
		Assert.assertFalse(flag);
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}

	public static void verifyStatusCode(Response response, int status){
		
		Assert.assertEquals(TestUtils.getStatusCode(response), status);
		if(TestUtils.getStatusCode(response)==status) {
			ExtentTestManager.getTest().log(Status.PASS, "Test Passed - Status Code matches");
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed - Status Code does not match");
		}
	}
	
	public static void verifyStatusMessage(Response response, String status){
		
		Assert.assertEquals(TestUtils.getStatusMessage(response), status);
		if(TestUtils.getStatusMessage(response).equals(status)) {
			ExtentTestManager.getTest().log(Status.PASS, "Test Passed - Response String Matches");
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed - Response String does not match");
		}
	}
	
}
