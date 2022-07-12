package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ArrayExerciseTest {
    @ParameterizedTest(name = "#{index} - {0}")
    @MethodSource("argsProvider")
    void testWithMultiArgMethodSource(String testName, int[] src, int shiftNumber, int[] expected) {
        ArrayExercise.leftShiftArray(src, shiftNumber);
        assertArrayEquals(expected, src);
    }

    static Stream<Arguments> argsProvider() {
        return Stream.of(
                arguments("simple happy path", new int[]{0, 1, 2, 3, 4, 5, 6}, 3, new int[]{3, 4, 5, 6, 0, 1, 2}),
                arguments("single shift", new int[]{0, 1, 2, 3, 4, 5, 6}, 1, new int[]{1, 2, 3, 4, 5, 6, 0}),
                arguments("negative shiftNumber", new int[]{0, 1, 2, 3, 4, 5, 6}, -2, new int[]{5, 6, 0, 1, 2, 3, 4}),
                arguments("shiftNumber greater array length", new int[]{0, 1, 2, 3, 4, 5, 6}, 10, new int[]{3, 4, 5, 6, 0, 1, 2}),
                arguments("zero shift", new int[]{0, 1, 2, 3, 4, 5, 6}, 0, new int[]{0, 1, 2, 3, 4, 5, 6})
        );
    }
}