package com.leszko.calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Tests the Calculator class.
 */
public class CalculatorTest {
     private Calculator calculator = new Calculator();
     /**
     * Tests the sum method of the Calculator.
     */
     @Test
     public void testSum() {
          // Test implementation
          assertEquals(5, calculator.sum(2, 3));
     }
    /**
     * Tests the sum method of the Calculator.
     */
     @Test
     public void testSum2() {
          // Test implementation
          assertEquals(6, calculator.sum(1,5));
     }
     /**
     * Tests the sum method of the Calculator.
     */
     @Test
     public void testSum3 () {
          // Test implementation
          assertEquals(9, calculator.sum(5, 4));
     }
}
