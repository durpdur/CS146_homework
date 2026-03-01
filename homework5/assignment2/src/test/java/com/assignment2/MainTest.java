package com.assignment2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testCountingSortOutput() {
        char[] arr = {'A', 'A', 'Z', 'B', 'H', 'K', 'L', 'Z', 'W', 'X', 'P'};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Main.countingSort(arr);

        String output = outputStream.toString();

        assertTrue(output.contains("[A, A, B, H, K, L, P, W, X, Z, Z]"));
        assertTrue(output.contains("[2, 1, 0, 0, 0, 0, 0, 1"));
        assertTrue(output.contains("11]"));
    }
}