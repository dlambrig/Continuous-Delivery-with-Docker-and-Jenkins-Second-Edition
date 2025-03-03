/**
 * This is the main file for the calculator source code
 * @author Leszko -Update For Homework 4
 * @version 1
*/
package com.leszko.calculator;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
/**
 * not sure what @service does
*/
@Service
/** 
 * The Calculator Class
*/
public class Calculator {
/** 
 * Adds together two numbers and returns the sum.
 * @param a The first number to add
 * @param b The second number to add
*/
	public int sum(int a, int b) {
		return a + b;
	}
}
