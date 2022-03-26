@regression
Feature: user could filter by color
  Scenario: user should be able to filter by color
    Given user navigate to homepage
    When Choose color red
    Then Click an item and check if the checked color is red