package com.RestAssuredFramework.StepDefination;

import static io.restassured.RestAssured.given;


import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.RestAssuredFramework.Page.DeleteRequestPage;
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
public class DeleteRequest {

	Response response;
	DeleteRequestPage drp = new DeleteRequestPage();
	Base base = new Base();
	private static final Logger log = LoggerFactory.getLogger(DeleteRequest.class);
	//Logger log = LogManager.getLogger("DeleteRequest");
	
	@Severity(SeverityLevel.NORMAL)
	@Step("Delete Request URL is Triggered!!")
	@Given("I get Delete request URL")
	public void i_get_delete_request_url() {
	
		RestAssured.baseURI = drp.getPro("URL");
		log.info("URL is getting successfull");
	}
	
	@Step("Getting Response!!")
	@When("I use Delete method and execute it")
	public void i_use_delete_method_and_execute_it() {

		response = given().contentType(ContentType.JSON).accept(ContentType.JSON).when().delete("users/2").then()
				.statusCode(204).log().all().extract().response();
		log.info("Response is generated");
	}

	@Step("Delete Request Triggered!!")
	@Then("I get Delete response body and respose code")
	public void i_get_delete_response_body_and_respose_code() {
		int statusCode = response.getStatusCode();
		System.out.println("status code = " + statusCode);
		Assert.assertEquals(statusCode, 204);
		
		log.info("Status code varification");
	}
}
