Feature: Calculator
  Scenario: Divide two numbers
    Given I have dividend and divisor: 6 and 3
    When the calculator divides them
    Then I receive 2 as the quotient
