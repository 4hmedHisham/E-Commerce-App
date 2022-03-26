@regression
Feature: user could Add item to Search items
  Scenario: user should be able to add search item such as nokia
    Given user navigate to homepage
    When searches for nokia
    Then the user should find items that have "nokia" in its name