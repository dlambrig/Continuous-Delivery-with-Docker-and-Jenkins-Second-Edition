package com.leszko.calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
     private Calculator calculator = new Calculator();

     @Test
     public void testSum() {
          assertEquals(5, calculator.sum(2, 3));
     }
     
     @Test
     public void testLargeSum() {
          assertEquals(10, calculator.sum(5, 5));
     }

    @Test
    public void testSumWithNegative() {
        assertEquals(1, calculator.sum(3, -2)); // Another scenario
    }

    @Test
    public void testSumWithNegativeValuesn() {
        assertEquals(-3, calculator.sum(-2, -1)); // Another scenario
    }

}
