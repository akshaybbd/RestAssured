package com.RestAssuredFramework.StepDefination;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.RestAssuredFramework.Page.PutRequestPage;
import com.RestAssuredFramework.Utility.AllureListener;

import io.cucumber.java.en.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Listeners({AllureListener.class})
public class PutRequest {

	Response response;
	PutRequestPage prpg = new PutRequestPage();
	Base base = new Base();
	private static final Logger log = LoggerFactory.getLogger(PutRequest.class);
	//Logger log = LogManager.getLogger("PutRequest");
	
	@Severity(SeverityLevel.NORMAL)
	@Step("Put Request URL is Triggered!!")
	@Given("I get Put request URL")
	public void i_get_put_request_url() {
	
		RestAssured.baseURI = prpg.getPro("URL");
		log.info("URL is getting successfull");
	}
	
	@Step("Getting Response!!")
	@When("I use Put method and execute it")
	public void i_use_put_method_and_execute_it() {
		JSONObject obj = new JSONObject();
		obj.put("name", "Akshay");
		obj.put("job", "Test Analyst");
		response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(obj.toJSONString()).when()
				.put("users/2").then().statusCode(200).log().all().extract().response();
		log.info("Response is generated");
	}
	@Step("Put Request Triggered!!")
	@Then("I get Put response body and respose code")
	public void i_get_put_response_body_and_respose_code() {
		int statusCode = response.getStatusCode();
		System.out.println("status code = " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		log.info("Status code varification");
	}

}

