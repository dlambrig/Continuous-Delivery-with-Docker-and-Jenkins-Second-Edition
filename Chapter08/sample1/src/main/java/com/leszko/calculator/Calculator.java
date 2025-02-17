package com.leszko.calculator;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * This is the calculator class.
 * It Provides basic functionality.
 */
@Service
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
