package com.leszko.calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


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

     @Test
     public void testSumWithZeroShouldNotEqualOne() {
         assertNotEquals("The sum of 0 and 0 should not be 1",1, calculator.sum(0, 0));
     }
     @Test
     public void testUmlNumber1IsThree() {
         assertEquals("umlNUMBER1 should be equal to 3", 3, Calculator.umlNUMBER1);
     }
     @Test
     public void testSumWithIntegerOverflow() {
         int largeNumber = Integer.MAX_VALUE;
         assertTrue("Sum should result in integer overflow", 
                    calculator.sum(largeNumber, 1) < 0);
     }

     @Test
     public void testSumWithIntegerUnderflow() {
         int smallNumber = Integer.MIN_VALUE;
         assertTrue("Sum should result in integer underflow", 
                    calculator.sum(smallNumber, -1) > 0);
     }


     
}
