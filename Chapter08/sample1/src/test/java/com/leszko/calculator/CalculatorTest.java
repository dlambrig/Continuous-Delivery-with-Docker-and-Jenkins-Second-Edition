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
        int result = calculator.sum(3, 5); 
        assertEquals(8, result, "3 + 5 should equal 8");
    }

    @Test
    public void testSum_negativeNumbers() {
        int result = calculator.sum(-3, -5);
        assertEquals(-8, result, "-3 + -5 should equal -8");
    }

    @Test
    public void testSum_mixedNumbers() {
        int result = calculator.sum(-3, 5); 
        assertEquals(2, result, "-3 + 5 should equal 2");
    }

    @Test
    public void testSum_withZero() {
        int result = calculator.sum(0, 5); 
        assertEquals(5, result, "0 + 5 should equal 5");
    }
}
