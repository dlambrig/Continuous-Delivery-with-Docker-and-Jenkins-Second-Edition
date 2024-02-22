package com.leszko.calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


public class CalculatorTest {
     private Calculator calculator = new Calculator();   
     
     @Test
     public void testSum() {
          try{
               assertEquals(5, calculator.sum(2, 3));
               assertEquals(-5, calculator.sum(-2, -3));
               assertEquals(3, calculator.sum(3, 0));
               assertEquals(1, calculator.sum(4, -3));
           }
          catch (Exception e) {
           throw new CalculatorException("Invalid expression: ", e);
         }
     }


     @Test
     public void testSumWithZeroShouldNotEqualOne() {
         
         try{
               assertNotEquals("The sum of 0 and 0 should not be 1",1, calculator.sum(0, 0));
           }
         
           throw new CalculatorException("Invalid expression: ", e);
         }
     }
     
     @Test
     public void testSumWithIntegerOverflow() {
         int largeNumber = Integer.MAX_VALUE;
         try {
              assertTrue("Sum should result in integer overflow", calculator.sum(largeNumber, 1) < 0);
         }
         catch (Exception e) {
              fail("expected exception " + exception + ";);
         }
     }




     
}
