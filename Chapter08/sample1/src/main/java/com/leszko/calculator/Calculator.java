package com.leszko.calculator;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
/**
 * This class represents a simple calculator with basic operations.
 * It is used for demonstrating Checkstyle validation.
 */
public class Calculator {
        final static int umlNUMBER1 = 3;
	@Cacheable("sum")
	/**
 * Adds two numbers and returns the sum.
 *
 * @param a First number
 * @param b Second number
 * @return Sum of a and b
 */
	public int sum(int a, int b) {
		return a + b;
	}
}
