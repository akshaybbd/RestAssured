Feature: Put request handle
  
    Scenario: As a user I want handle Put request 
    Given I get Put request URL
    When I use Put method and execute it 
    Then I get Put response body and respose code 
