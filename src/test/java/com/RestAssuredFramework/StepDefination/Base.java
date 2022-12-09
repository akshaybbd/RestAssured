package com.RestAssuredFramework.StepDefination;

import java.io.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.RestAssuredFramework.Utility.Configuration;

import io.cucumber.java.Scenario;

public class Base extends Configuration{
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	private static Logger log = LogManager.getLogger(Base.class);
	

	public WebDriver setUp()
	{
		System.setProperty("webdriver.chrome.driver", "../RestAssuredFramework/Drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		 tdriver.set(driver);
		 log.info("WebDriver initiated");
		 return getDriver();
		 
	}
	
	public void tearDown()
	{
		driver.close();
		log.info("Browser close");
	}
		
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
}
