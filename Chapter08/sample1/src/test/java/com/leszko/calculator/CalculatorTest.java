package com.leszko.calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
     private Calculator calculator = new Calculator();

     @Test
     public void testSum() {
        assertEquals(5, calculator.sum(2, 3));
        assertEquals(-1, calculator.sum(-2, 1));
        assertEquals(Integer.MIN_VALUE, calculator.sum(Integer.MIN_VALUE + 1, -1));
     }
}
