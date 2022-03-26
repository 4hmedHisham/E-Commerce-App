@regression
Feature: user could Add item to cart
  Scenario: user should be able to add item to cart
    Given user navigate to homepage
    When user navigate to Sepcific item
    And  adds item to cart
    Then Checks that item is added to cart