package com.homework2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    void lomutoTestSorted() {
        int[] arr = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};

        int p = Main.lomotoPartition(arr);
        int pivot = arr[p];

        // Check smaller on left side of pivot
        for (int i = 0; i < p; i++) {
            assertTrue(arr[i] <= pivot);
        }

        // Check bigger on right side of pivot
        for (int i = p + 1; i < arr.length; i++) {
            assertTrue(arr[i] > pivot);
        }
    }

    @Test
    void lomutoTestEmpty() {
        int[] arr = {84, 3, 7, 1, 9, 6, 2, 5};

        int p = Main.lomotoPartition(arr);
        int pivot = arr[p];

        for (int i = 0; i < p; i++) {
            assertTrue(arr[i] <= pivot);
        }
        for (int i = p + 1; i < arr.length; i++) {
            assertTrue(arr[i] > pivot);
        }
    }

    @Test
    void lomutoTestUnsorted() {
        int[] arr = {84, 3, 7, 1, 9, 6, 2, 5};

        int p = Main.lomotoPartition(arr);
        int pivot = arr[p];

        for (int i = 0; i < p; i++) {
            assertTrue(arr[i] <= pivot);
        }
        for (int i = p + 1; i < arr.length; i++) {
            assertTrue(arr[i] > pivot);
        }
    }

    @Test
    void hoareTestSorted() {
        int[] arr = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};

        int pivot = arr[0];
        int p = Main.hoarePartition(arr);

        // Check smaller on left side of pivot
        for (int i = 0; i <= p; i++) {
            assertTrue(arr[i] <= pivot);
        }

        // Check bigger on right side of pivot
        for (int i = p + 1; i < arr.length; i++) {
            assertTrue(arr[i] >= pivot);
        }
    }

    @Test
    void hoareTestEmpty() {
        int[] arr = {};
        int p = Main.hoarePartition(arr);

        assertEquals(-1, p);
    }

    @Test 
    void hoareTestUnsorted() {
        int[] arr = {84, 3, 7, 1, 9, 6, 2, 5};
        int pivot = arr[0];
        int p = Main.hoarePartition(arr);

        for (int i = 0; i <= p; i++) {
            assertTrue(arr[i] <= pivot);
        }

        for (int i = p + 1; i < arr.length; i++) {
            assertTrue(arr[i] >= pivot);
        }
    }

}
