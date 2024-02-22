package com.leszko.calculator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testSumWithPositiveNumbers() {
        assertEquals(5, calculator.sum(2, 3));
    }

    // Additional tests as described earlier
}
