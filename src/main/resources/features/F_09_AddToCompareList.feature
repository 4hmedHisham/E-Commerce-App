@regression
Feature: user could Add item to comparelist
  Scenario: user should be able to add item to comparelist
    Given user navigate to homepage
    When user navigate to Sepcific item
    And  adds item to comparelist
    Then Checks that item is added to comparelist