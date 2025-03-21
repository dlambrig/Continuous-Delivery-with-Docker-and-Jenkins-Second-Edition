package com.leszko.calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Unit test for the Calculator class.
 */
public class CalculatorTest {
     private Calculator calculator = new Calculator();

     /**
      * Tests the sum method of the Calculator class.
      */
     @Test
     public void testSum() {
          assertEquals(5, calculator.sum(2, 3));
     }
}
