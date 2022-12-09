Feature: Delete request handle
  
    Scenario: As a user I want handle Delete request 
    Given I get Delete request URL
    When I use Delete method and execute it 
    Then I get Delete response body and respose code 
