@regression
Feature: user could Login
  Scenario: user should be able to Login with valid data

    Given user navigate to homepage
    When user enters valid login data
    Then uer login sucessfully