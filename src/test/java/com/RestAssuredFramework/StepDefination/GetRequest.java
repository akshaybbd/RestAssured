package com.RestAssuredFramework.StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.*;


import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.RestAssuredFramework.Page.GetRequestPage;
import com.RestAssuredFramework.Utility.AllureListener;

import static io.restassured.RestAssured.*;

@Listeners({AllureListener.class})
public class GetRequest extends GetRequestPage {

	private static final Logger log = LoggerFactory.getLogger(GetRequest.class);
	//Logger log = LogManager.getLogger("GetRequest");
	GetRequestPage grp = new GetRequestPage();
	Response response;
	Base base = new Base();
	
	@Severity(SeverityLevel.NORMAL)
	@Step("Get URL is Triggered!!")
	@Given("I get request URL")
	public void i_get_request_url() {
	
		RestAssured.baseURI = grp.getPro("URL");
		log.info("URL is getting successfull");
	}
	
	@Step("Getting Response!!")
	@When("I use get method and execute it")
	public void i_use_get_method_and_execute_it() {
		response = given().accept(ContentType.JSON).contentType(ContentType.JSON).get("users?page=2").then()
				.statusCode(200).log().all().extract().response();
		log.info("Response is getting successfull");
	}

	@Step("Get Request Triggered!!")
	@Then("I get response body and respose code")
	public void i_get_response_body_and_respose_code() {
		int statusCode = response.getStatusCode();
		System.out.println("status code = " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		log.info("Status code varification");
	}
}
