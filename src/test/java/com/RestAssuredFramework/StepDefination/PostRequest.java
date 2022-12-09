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

import org.apache.tika.io.IOUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.RestAssuredFramework.Page.PostRequestPage;
import com.RestAssuredFramework.Utility.AllureListener;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Listeners({AllureListener.class})
public class PostRequest {

	Response response;
	PostRequestPage prp = new PostRequestPage();
	Base base = new Base();
	private static final Logger log = LoggerFactory.getLogger(PostRequest.class);
	//Logger log = LogManager.getLogger("PostRequest");

	@Severity(SeverityLevel.NORMAL)
	@Step("Post Reequest URL is Triggered!!")
	@Given("I get Post request URL")
	public void i_get_post_request_url() {
	
		RestAssured.baseURI = prp.getPro("URL");
		log.info("URL Is getting");
	}

	@Step("Getting Response!!")
	@When("I use Post method and execute it")
	public void i_use_post_method_and_execute_it() throws IOException {
		FileInputStream fis = new FileInputStream(".\\configuration\\simple.json");
		JSONObject obj = new JSONObject();
		obj.put("name", "Akshay");
		obj.put("job", "Test Analyst");
		response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(obj.toJSONString()).when()
				.post("users").then().statusCode(201).log().all().extract().response();
		log.info("Response is generated");

	}
	@Step("Post Request Triggered!!")
	@Then("I get Post response body and respose code")
	public void i_get_post_response_body_and_respose_code() {
		int statusCode = response.getStatusCode();
		System.out.println("status code = " + statusCode);
		Assert.assertEquals(statusCode, 201);
	
		log.info("Status Code verified");
	}

}
