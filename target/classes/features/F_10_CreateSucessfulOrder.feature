@regression
Feature: user could CreateOrder
  Scenario: user should be able to add item to CreateOrder
    Given user navigate to homepage
    When user clicks cart icon
    And  user accepts tos
    And  user checks out
    And  user filll purchuse data
    And  user clicks next until confirmation page
    Then user checks if order is done successfully