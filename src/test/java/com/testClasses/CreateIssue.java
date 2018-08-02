package com.testClasses;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Core.BaseAssertion;
import com.Core.BaseTest;
import com.Core.RESTCalls;
import com.utils.PayloadGenerator;
import com.utils.URL;

import io.restassured.response.Response;

public class CreateIssue {

	private String sessionID;
	Response response;

	private static Logger log = LogManager.getLogger(CreateIssue.class.getName());

	@BeforeMethod
	public void setUp() {
		sessionID = BaseTest.doLogin();
	}

	@Test
	public void createIssue() {
		log.info("Starting Create Issue Test");
		String URI = URL.getEndPoint("/rest/api/2/issue/");
		String createIssuePayLaod = PayloadGenerator.generatePayLoadString("CreateBug.json");
		response = RESTCalls.POSTRequest(URI, createIssuePayLaod, sessionID);
		BaseAssertion.verifyStatusCode(response, 201);
		
	}

}
