package org.example;

public class ArrayExercise {

    public static void leftShiftArray(int[] a, int shiftNumber) {
        if (a.length < 2) {
            return;
        }
        int normalizedShiftNumber = (a.length + shiftNumber % a.length) % a.length;

        int i;
        int previousNewPositionValue;
        int newPosition = (a.length - normalizedShiftNumber) % a.length;
        int iValue = a[0];
        do {
            previousNewPositionValue = a[newPosition];
            a[newPosition] = iValue;
            i = newPosition;
            newPosition = (i - normalizedShiftNumber + a.length) % a.length;
            iValue = previousNewPositionValue;
        }
        while (i != 0);
    }
}
