@regression
Feature: user could Register
  Scenario: user should be able to resigter with valid data

    Given user open chrome borwser
    And user navigate to homepage
    When user Clicks Register and  enters valid data
    Then User Register Sucessfully