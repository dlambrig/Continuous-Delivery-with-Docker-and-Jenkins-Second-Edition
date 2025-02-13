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
    public void testSum_positiveNumbers() {
        assertEquals(8, calculator.sum(3, 5));
    }

    @Test
    public void testSum_negativeNumbers() {
        assertEquals(-8, calculator.sum(-3, -5));
    }

    @Test
    public void testSum_mixedNumbers() {
        assertEquals(2, calculator.sum(-3, 5));
    }

    @Test
    public void testSum_withZero() {
      
        assertEquals(5, calculator.sum(0, 5));
    }
}
