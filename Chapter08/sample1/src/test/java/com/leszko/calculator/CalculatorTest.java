package com.leszko.calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
     private Calculator calculator = new Calculator();

     @Test
     public void testSum() {
        assertEquals(5, calculator.sum(2, 3));
        assertEquals(-1, calculator.sum(-2, 1));
        assertEquals(0, calculator.sum(0, 0));
        assertEquals(10, calculator.sum(5, 5));
        assertEquals(-10, calculator.sum(-5, -5));
        assertEquals(3, calculator.sum(0, 3));  // More test cases
        assertEquals(-3, calculator.sum(0, -3));
        assertEquals(7, calculator.sum(4, 3));
        assertEquals(-7, calculator.sum(-4, -3));
     }
}
