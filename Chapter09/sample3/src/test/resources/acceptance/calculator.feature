Feature: Calculator
  Scenario: Sum two numbers
    Given I have two numbers: 1 and 2
    When the calculator sums them
    Then I receive 3 as a result
  Scenario: Division two numbers
    Given I have two numbers: 6 and 2
    When the calculator division them
    Then I receive 3 as a result
