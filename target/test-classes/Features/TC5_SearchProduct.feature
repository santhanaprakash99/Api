@SearchProduct
Feature: Search Product module API Automation

  Scenario Outline: Verify user search product through API
    Given User add headers for accessing searchProduct endpoint
    When User add request body for search product "<product>"
    And User send "POST" request for searchaProduct endpoint
    Then User should verify the status code is 200
    And User should verify the searchProduct response matches with "OK"

    Examples: 
      | product |
      | nuts    |
