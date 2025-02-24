package com.leszko.calculator;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * This class provides basic calculator operations.
 * It includes a method for summation with caching enabled.
 */
@Service
public class Calculator {
        final static int umlNUMBER1 = 3;

        /**
         * Adds two integers and caches the result.
         *
         * @param a First number
         * @param b Second number
         * @return The sum of a and b
         */
        @Cacheable("sum")
        public int sum(int a, int b) {
                return a + b;
        }
}

// Testing pull request pipeline
// Testing pull request pipeline
