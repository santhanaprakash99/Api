@City
Feature: City module API Automation

  Scenario Outline: Verify user Get citylist through API
    Given User add headers for the citylist
    When User add request body for citylist "<stateId>"
    And User send "POST" request for citylist endpoint 
    Then User should verify the status code is 200
    And User verify the citylist response message matches "Srivilliputtur" and save city id

    Examples: 
      | stateId|
      |    35 |
