Feature: Calculator
  Scenario: Divide two numbers
    Given I have two numbers: 6 and 2
    When the calculator divides them
    Then I receive 3 as a result
 
