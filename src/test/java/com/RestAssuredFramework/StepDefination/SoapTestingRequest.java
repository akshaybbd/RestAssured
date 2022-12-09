package com.RestAssuredFramework.StepDefination;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.tika.io.IOUtils;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class SoapTestingRequest {

	Response response;
	
	@Given("user get url")
	public void user_get_url() {
	    RestAssured.baseURI="https://www.dataaccess.com";
	}

	@When("user send reques")
	public void user_send_reques() throws IOException {
		FileInputStream fis = new FileInputStream(".\\configuration\\test1.xml");
		response = given()
					.header("Content-Type","text/xml")
					.and()
					.body(IOUtils.toString(fis,"UTF-8"))
				.when()
					.post("/webservicesserver/NumberConversion.wso")
				.then()
					.statusCode(200)
					.and()
					.log().all().extract().response();
	}

	@Then("user get response")
	public void user_get_response() {
	    XmlPath xmlpath= new XmlPath(response.asString());
	    
	    String number = xmlpath.getString("NumberToWordsResult");
	    System.out.println("Number is  : "+ number);
	}
	
}
