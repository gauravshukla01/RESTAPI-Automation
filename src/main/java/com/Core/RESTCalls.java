package com.Core;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;

public class RESTCalls {
	/*
	 * This call will be resposible to fire requests
	 */
	
	private static Logger log = LogManager.getLogger(RESTCalls.class.getName());
	
	public static Response GETRequest(String uRI) {
		
		log.info("Inside GETRequest call");
		
				RequestSpecification requestSpecification = RestAssured.given().config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).contentType(ContentType.URLENC);
		
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.proxy("proxy.cognizant.com", 6050);
		
		Response response = requestSpecification.get(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response POSTRequest(String uRI, String strJSON) {
		log.info("Inside POSTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).contentType(ContentType.URLENC);
		
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.proxy("proxy.cognizant.com", 6050);
		requestSpecification.body(strJSON);
		Response response = requestSpecification.post(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}
	
		
	public static Response POSTRequest(String uRI, String strJSON, String sessionID) {
		log.info("Inside POSTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).contentType(ContentType.URLENC);
		
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.proxy("proxy.cognizant.com", 6050);
		requestSpecification.body(strJSON);
		requestSpecification.header("cookie", "JSESSIONID=" + sessionID+"");
		Response response = requestSpecification.post(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}
	

	public static Response PUTRequest(String uRI, String strJSON) {
		log.info("Inside PUTRequest call");
		RequestSpecification requestSpecification = RestAssured.given().config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).contentType(ContentType.URLENC);
		
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.proxy("proxy.cognizant.com", 6050);
		requestSpecification.body(strJSON);
		Response response = requestSpecification.put(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response DELETERequest(String uRI, String strJSON) {
		log.info("Inside DELETERequest call");
		RequestSpecification requestSpecification = RestAssured.given().config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).contentType(ContentType.URLENC);
		
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.proxy("proxy.cognizant.com", 6050);
		requestSpecification.body(strJSON);
		Response response = requestSpecification.delete(uRI);
		log.debug(requestSpecification.log().all());
		return response;
	}
}
