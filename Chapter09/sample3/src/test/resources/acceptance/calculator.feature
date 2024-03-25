Feature: Calculator
  Scenario: Sum two numbers
    Given I have two numbers: 2 and 2
    When the calculator divs them
    Then I receive 1 as a result
