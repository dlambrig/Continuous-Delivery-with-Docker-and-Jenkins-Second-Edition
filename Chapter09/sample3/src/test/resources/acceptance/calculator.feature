Feature: Calculator
  Scenario: Divide two numbers
    Given I have two numbers: 10 and 0
    When the calculator divides them
    Then I receive 5 as a result