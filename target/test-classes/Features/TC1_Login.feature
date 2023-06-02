@Login
Feature: Login module API Automation

  Scenario: Get User logtoken from login endpoint
    Given Use  add header
    When User add basic authentication for login
    And User send "POST" request for login endpoint
    Then User should verify the status code is 200
    And User verify the login response body firstName present as "Santhana" and get the logtoken
