@regression
Feature: user could change currencies
  Scenario: user should be able to switch to Euro

    Given user navigate to homepage
    When user Changes currency to euro at homepage
    Then Check Currency Changed to euro

  Scenario: user should be able to switch to Dollar

    Given user navigate to homepage
    When user Changes currency to dollar at homepage
    Then Check Currency Changed to dollar