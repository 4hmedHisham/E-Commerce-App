@regression
Feature: user could change Categories
  Scenario: user should be able to Computers

    Given user navigate to homepage
    When user clicks on "Computers" button
    Then Check that category is "Computers"

  Scenario: user should be able to switch to Electronics

    Given user navigate to homepage
    When user clicks on "Electronics" button
    Then Check that category is "Electronics"