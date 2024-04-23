/*
B211202034 - Ayşe Yasemin İlik
Software Verification & Validation
Create a parameterized test using JUnit5 that tests all the values tested by testDivision1,
testDivision2, testDivision3, testDivision4, and testDivision5 methods
https://github.com/yasemin509/SVV-Homework.git
*/
package org.example;

import org.example.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("divisionTestData")
    void testDivision(double dividend, double divisor, double expectedResult) {
        assertEquals(expectedResult, Calculator.divide((float) dividend, (float) divisor));
    }

    private static Stream<Arguments> divisionTestData() {
        return Stream.of(
                Arguments.of(10, 2, 5),
                Arguments.of(10, 4, 2.5),
                Arguments.of(12.5, 2.5, 5),
                Arguments.of(10, 2.5, 4),
                Arguments.of(12.5, 5, 2.5)
        );
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.divide(12.5F, 0),
                "IllegalArgumentException expected."
        );
    }
}
