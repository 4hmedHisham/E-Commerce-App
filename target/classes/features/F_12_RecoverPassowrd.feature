@regression
Feature: user could Recover Password
  Scenario: user should be able to Recover Password
    Given user navigate to homepage
    And Press Logout
    And PressLogin
    And user chooses  password recovery
    And TypeMail
    When user presses recover password
    Then User should be able to recover passowrd