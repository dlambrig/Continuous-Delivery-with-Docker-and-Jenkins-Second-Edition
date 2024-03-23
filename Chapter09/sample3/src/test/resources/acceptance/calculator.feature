Feature: Calculator
  Scenario: Sum two numbers
    Given I have two numbers: 1 and 2
    When the calculator sums them
    Then I receive 3 as a result
  Scenario: Divide two numbers
    Given I have two numbers: 6 and 2
    When the calculator divides them
    Then I receive 3 as a result
  Scenario: Division by zero error
    Given I have two numbers: 5 and 0
    When the calculator attempts to divide them
    Then I should see an error message
