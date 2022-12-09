# Getting started with RestAssured


## Create a new Maven Project

  Step 1: To create a maven project click on New and then select Maven Project option.

!['MavenP'](FrameworkImages/MavenP.png)

  Step 2: Select Maven Project and click on Next.

  Step 3: Select "Create a Simple project" Checkbox and click Next.

!['SimpleProject'](FrameworkImages/SimpleProject.png)

  If you don't want to create a "Simple Project",then don't select "Create a Simple project".
  Click on Next and Below screen will appear.Select maven-archetype-quickstart option as shown below and click on Next.

!['Archetype'](FrameworkImages/Archetype.png)

  Step 4: Mention the "Group Id" and "Artifact Id" and click on Finish.

!['GroupID'](FrameworkImages/GroupID.png)

  Step 5: The structure of the project looks as shown in the below Image.

!['Structure'](FrameworkImages/Structure.png)

  Step 6: POM.xml will look like below image

!['Pom'](FrameworkImages/Pom.png)
  


## Add REST Assured Dependency 

  Step 1: Please visit website MVN Repository <https://mvnrepository.com/>

  Step 2: Type For Restassured in search box.

  Step 3: Click on latest Version.

  Step 4: Copy the content as shown below and paste in <dependencies> </dependencies> in POM.xml

```xml
<!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>5.1.1</version>
    <scope>test</scope>
</dependency>
```

  Step 5: Updated POM.xml will look like below Image.

!['GroupID'](FrameworkImages/RestPOM.png)

  Step 6: Update Project to invoke dependencies. Right Click on Project and Goto Maven and select Update project
or you can use shortcut key Alt+F5

!['GroupID'](FrameworkImages/ProjectUpdate.png)


Assignment No 1
-------------
1. Create Maven Project Add Simple class file for RestAssured
2. Try to include All Rest methods (eg.get put post delete) For dumy API's you can use <https://reqres.in/> or <https://designer.mocky.io/>

## Lets Start with Cucumber BDD framework

1. What is Cucumber?
   + Cucumber is one such open-source tool, which supports Behaviour Driven Development(BDD).
   In simple words, Cucumber can be defined as a testing framework, driven by plain English.
   It serves as documentation, automated tests, and development aid – all in one.	
2. Feature File :
   + The Feature keyword's aim is to collect relevant scenarios and provide a high level description of a software feature
   + Create a folder with name features. Then create the feature file in this folder.
   The feature file should be saved with extension .feature.
   This feature file contains the test scenarios created to test the application.
   The Test Scenarios are written in Gherkins language in the format of Given, When, Then, And,But.
   + Given: Given steps are used to describe the initial context of the system - the scene of the scenario
   + When : When steps are used to describe an event, or an action.
   + Then: Then steps are used to describe an expected outcome, or result.

```feature
#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Title of your scenario
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |

   
```

4. Step definition/glue code :
   + StepDefinition acts as an intermediate to your runner and feature file.
     It stores the mapping between each step of the scenario in the Feature file. So when you run the scenario,
     it will scan the step definition file to check matched glue or test code.
```Java
public class Example  {

	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() {
	    //Code should be written here
	}
	@When("I complete action")
	public void i_complete_action() {
       //Code should be written here
	}
	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
       //Code should be written here
	}
}

```


Assignment No 2
-------------
1. Create feature file For RestAssured methods.
2. Create step definition file for above feature file.
3. Create feature file for get,put,post, delete method and create step definition for the same.


## Integration of REST Assured with TestNG

1. What is TestNG?
   + TestNG is an open source automated testing framework; where NG means NextGeneration.
   + TestNG is inspired by JUnit which uses the annotations (@). 
   + Using TestNG, you can generate a proper report, and you can easily come to know how many test cases are passed, failed, and skipped. You can execute the failed test cases separately.

2. Add TestNG and Cucumber TestNG Dependencies
   + Copy the content as shown below and paste in <dependencies> </dependencies> in POM.xml

```xml
<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.4.0</version>
    <scope>test</scope>
</dependency>
```

```xml
<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-testng -->
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-testng</artifactId>
    <version>7.3.4</version>
</dependency>
```

3. Create a TestNG Cucumber Runner class to execute the test scenarios
   + We need to create a class called Runner class to run the tests. This class will use the TestNG annotation @RunWith(), 
   which tells TestNG what is the test runner class. TestRunner should be created under src/test/java within the folder called runner.

```Java
package com.example.Cucumber_TestNGDemo.runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(tags = "", features = "src/test/resources/features/Login.feature", glue = "com.example.Cucumber_TestNGDemo.definitions")
 
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
 
}
```
4. After creating TestNg runner you need to convert your Project in TestNG. For converting Right click on project then click on TestNG then select convert TestNG
   It will create testng.xml file

!['GroupID'](FrameworkImages/ConvertTestNG.png)

```XML
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite">

  <test name="Example TestNG Runner">
		<classes>
			<class name="com.example.Cucumber_TestNGDemo.definitions" />
		</classes>
	</test>
</suite> <!-- Suite -->

```
5. Test Execution through TestNG and testng.xml
   + Go to Runner class and right click Run As TestNG Test. The tests will run as TestNG tests.
   + You can also run from testng.xml by right click on it then select RunAs TestNG Suite
6. TestNG Report Generation
   + After test execution, refresh the project, a new folder with name test-output will be generated. This folder contains the reports generated by TestNG.
   + We are interested in ’emailable-report.html’ report. Open ’emailable-report.html’, as this is a html report open it with browser.


Assignment No 3
-------------
1. Create a Cucumber TestNg runner for step definitions
2. Create TestNG Suite in testng.xml file and ad cucumber TestNG runner


```sh
Reference Material:
```
* [RestAssured Biginner Tutorials Playlist](https://www.youtube.com/playlist?list=PLhW3qG5bs-L8xPrBwDv66cTMlFNeUPdJx)
* [RestAssured GitHub page](https://rest-assured.io/)
* [RestAssured Article](https://www.hascode.com/2011/10/testing-restful-web-services-made-easy-using-the-rest-assured-framework/)
* [API Introduction](https://hevodata.com/learn/restassured-framework/)
* [RestAssured Tutorial](https://www.toolsqa.com/rest-assured-tutorial/)








	



