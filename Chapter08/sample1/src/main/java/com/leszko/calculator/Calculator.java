package com.leszko.calculator;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
/**
 * This is the calculator class.
 * Provides basic functionality.
 */
public class Calculator {
        final static int umlNUMBER1 = 3;
	
	/**
	 * adds two numbers together.
	 * @param a first number
	 * @param b second number
	 * @return the sum of and a and b
	 */
	@Cacheable("sum")
	public int sum(int a, int b) {
		return a + b;
	}
}
