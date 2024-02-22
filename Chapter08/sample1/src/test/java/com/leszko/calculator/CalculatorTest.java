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
     public void testSumWithNegativeNumbers() {
          assertEquals(-5, calculator.sum(-2, -3));
     }
     @Test
     public void testSumWithZero() {
         assertEquals(3, calculator.sum(3, 0));
         assertEquals(0, calculator.sum(0, 0));
     }
         @Test
     public void testSumWithPositiveAndNegativeNumbers() {
        assertEquals(1, calculator.sum(4, -3));
    }
    
}
