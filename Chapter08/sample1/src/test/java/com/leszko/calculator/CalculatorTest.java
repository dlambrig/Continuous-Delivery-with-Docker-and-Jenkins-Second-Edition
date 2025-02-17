package com.leszko.calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This is a test class for the Calculator.
 * It contains other unit tests.
 */
public class CalculatorTest {
     private Calculator calculator = new Calculator();

     @Test
     public void testSum() {
          assertEquals(5, calculator.sum(2, 3));
     }
}
