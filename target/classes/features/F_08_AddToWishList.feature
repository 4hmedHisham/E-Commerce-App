@regression
Feature: user could Add item to wishlist
  Scenario: user should be able to add item to wishlist
    Given user navigate to homepage
    When user navigate to Sepcific item
    And  adds item to wishlist
    Then Checks that item is added to wishlist