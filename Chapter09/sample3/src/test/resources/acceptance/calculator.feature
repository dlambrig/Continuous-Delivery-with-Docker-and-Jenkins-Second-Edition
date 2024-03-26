Feature: Calculator
  Scenario: Division by zero error
    Given I have two numbers: 0 and 5
    When the calculator attempts to divide them
    Then I should see an error message
