package com.leszko.calculator;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
/**
 * added comments in calculator.java to fix the comment.
 */
@Service
public class Calculator {
        final static int UMLNUMBER1 = 3; //To match the pattern for constant
	@Cacheable("sum")
	public int sum(int a, int b) {
		return a + b;
	}
}
