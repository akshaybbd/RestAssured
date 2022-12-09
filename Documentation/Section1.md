!['RestAssured Logo'](IntroductionImages/RestAssuredLogo.png)

## Introduction


```sh
What is RestAssured?
```
* RestAssured is Java library which is highly used in API Test Automation. REST stands for **RE**presentational **S**tate **T**ransfer
* The libraries based on the RestAssured library are also capable of validating the HTTP responses from the server.
* Response status code, body, message, headers, and so on can be tested with the Rest Assured library.
* It can be integrated with build tools like Maven, unit test frameworks like JUnit and TestNG, Behavior Driven Development(BDD ).
```sh
What is API?
```
* API stands for Application Programming Interface that allows two application to interact with each other.

**For Example**: 

API like menu in Restaurant.The menu provides a list of dishes you can order, along with a description of each dish When you oder something,

the restaurant's kitchen does the work and provides you some dishes.You don't know exactly how the restaurant prepares that food, and you really don't want to know.

Similarly, API is the messenger that delivers your request to the provider that you are requesting it from and then delivers the response back to you.

!['Example'](IntroductionImages/RestaurantExample.png)

!['API Working'](IntroductionImages/ApiWorking.png)
```sh
Different API methods in RestAssured :
```


| Methods |                                          Description                                          | 
|---------|:---------------------------------------------------------------------------------------------:|
  | GET   |                       To Retrieves the information at a particular URL                        |
| POST    | 	Used to send information to the server like uploading data and also to develop a new entity. |
| PUT     |  Updates the previous resource if it exists or creates new information at a particular URL.   |
 |DELETE  |                    Deletes all current representations at a specific URL.                     |
 | PATCH  |                            Another method  used for partial updates of resources                             |


!['API Methods'](IntroductionImages/ApiMethods.png)
```sh
Prerequisites:
```

1. JDK (Java)
    + First thing we need Java (JDK) in your system To check JDK Version hit `java -version` command In CMD
2. IDE (Integrated Development Environment)
    + Second thing is we need IDE For java development. you can use Eclipse,IntelliJ or any other IDE
3. MAVEN
    + Maven provides functionality to automatically download dependency jar files for you and while building the jar/war u don't have to set up manually each time. Maven takes care of it.
    + `mvn install`This is one time command,This command builds the maven project and installs the project files (JAR, WAR, pom.xml, etc) to the local repository.

```sh
Links for Download Tools and softwares
```
1. JDK      :  <https://www.oracle.com/java/technologies/downloads/>
2. Eclipse  : <https://www.eclipse.org/downloads/>
3. IntelliJ : <https://www.jetbrains.com/idea/download/#section=windows>
4. Maven    :  <https://maven.apache.org/download.cgi>

```sh
HTTP Status Code 
```
* When a browser requests a service from a web server, an error may occur. This is list of HTTP status messages that might be returned.

!['statuscode'](IntroductionImages/statuscode1.jpg)

```sh
Required Dependencies:
```
* RestAssured
```xml
<!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>5.1.1</version>
    <scope>test</scope>
</dependency>
```

