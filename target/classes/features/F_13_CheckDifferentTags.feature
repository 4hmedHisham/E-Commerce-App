@regression
Feature: user could Choose different tags
  Scenario: user should be able to Choose different tags
    Given user navigate to all tags
    And User Clicks "nice" tag
    Then User should directed to "nice" tag
  Scenario: user should be able to Choose different tags
    Given user navigate to all tags
    And User Clicks "cool" tag
    Then User should directed to "cool" tag
    Then User Closes Chrome