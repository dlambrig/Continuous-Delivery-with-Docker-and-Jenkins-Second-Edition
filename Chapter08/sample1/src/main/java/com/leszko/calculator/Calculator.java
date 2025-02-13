package com.leszko.calculator;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * The {@code Calculator} class provides basic arithmetic operations.
 * It includes caching for optimized performance.
 * 
 */
@Service
public class Calculator {
        final static int umlNUMBER1 = 3;
	@Cacheable("sum")
	public int sum(int a, int b) {
		return a + b;
	}
}
