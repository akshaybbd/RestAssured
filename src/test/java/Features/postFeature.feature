Feature: Post request handle
  
    Scenario: As a user I want handle Post request 
    Given I get Post request URL
    When I use Post method and execute it 
    Then I get Post response body and respose code 
