package com.durpdur;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private static void assertIsMaxHeap(WordFreq[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n) {
                assertTrue(arr[i].frequency >= arr[left].frequency,
                        "Error: parent[" + i + "] < leftChild[" + left + "]");
            }
            
            if (right < n) {
                assertTrue(arr[i].frequency >= arr[right].frequency,
                        "Error: parent[" + i + "] < rightChild[" + right + "]");
            }
        }
    }

    private static int maxFrequency(WordFreq[] arr) {
        int max = Integer.MIN_VALUE;
        for (WordFreq wf : arr) {
            max = Math.max(max, wf.frequency);
        }
        return max;
    }

    @Test
    void buildMaxHeap_placesMaximumAtRoot_forCustomerSurveyData() {
        WordFreq[] customerSurveyData = {
                new WordFreq("happy", 400),
                new WordFreq("satisfied", 100),
                new WordFreq("neutral", 300),
                new WordFreq("would buy again", 200),
                new WordFreq("terrible", 160),
                new WordFreq("inconvenient", 900),
                new WordFreq("difficult to use", 100),
                new WordFreq("easy to use", 140),
                new WordFreq("would recommend to friends", 800),
                new WordFreq("visit the store", 700)
        };

        MaxHeap heap = new MaxHeap(customerSurveyData);
        heap.buildMaxHeap();

        assertEquals(900, customerSurveyData[0].frequency);
        assertEquals("inconvenient", customerSurveyData[0].word);
    }

    @Test
    void buildMaxHeap_producesValidHeap_forCustomerSurveyData() {
        WordFreq[] customerSurveyData = {
                new WordFreq("happy", 400),
                new WordFreq("satisfied", 100),
                new WordFreq("neutral", 300),
                new WordFreq("would buy again", 200),
                new WordFreq("terrible", 160),
                new WordFreq("inconvenient", 900),
                new WordFreq("difficult to use", 100),
                new WordFreq("easy to use", 140),
                new WordFreq("would recommend to friends", 800),
                new WordFreq("visit the store", 700)
        };

        MaxHeap heap = new MaxHeap(customerSurveyData);
        heap.buildMaxHeap();

        assertIsMaxHeap(customerSurveyData);
    }

    @Test
    void buildMaxHeap_rootFrequencyEqualsOverallMax_forRandomData() {
        WordFreq[] data = {
                new WordFreq("a", 5),
                new WordFreq("b", 1),
                new WordFreq("c", 7),
                new WordFreq("d", 3),
                new WordFreq("e", 6),
        };

        int expectedMax = maxFrequency(data);

        MaxHeap heap = new MaxHeap(data);
        heap.buildMaxHeap();

        assertEquals(expectedMax, data[0].frequency);
        assertIsMaxHeap(data);
    }

    @Test
    void buildMaxHeap_handlesSingleElement() {
        WordFreq[] data = { new WordFreq("only", 42) };

        MaxHeap heap = new MaxHeap(data);
        heap.buildMaxHeap();

        assertEquals(42, data[0].frequency);
        assertEquals("only", data[0].word);
        assertIsMaxHeap(data);
    }

    @Test
    void buildMaxHeap_handlesDuplicateFrequencies() {
        WordFreq[] data = {
                new WordFreq("x", 10),
                new WordFreq("y", 10),
                new WordFreq("z", 10),
                new WordFreq("w", 10),
        };

        MaxHeap heap = new MaxHeap(data);
        heap.buildMaxHeap();

        // Any element could be root since all equal, but heap property must still hold.
        assertEquals(10, data[0].frequency);
        assertIsMaxHeap(data);
    }

    @Test
    void buildMaxHeap_keepsValidHeapIfAlreadyHeapified() {
        // This is already a max-heap by frequency:
        //           100
        //       90       80
        //     70 60    50 40
        WordFreq[] data = {
                new WordFreq("root", 100),
                new WordFreq("l", 90),
                new WordFreq("r", 80),
                new WordFreq("ll", 70),
                new WordFreq("lr", 60),
                new WordFreq("rl", 50),
                new WordFreq("rr", 40),
        };

        MaxHeap heap = new MaxHeap(data);
        heap.buildMaxHeap();

        assertEquals(100, data[0].frequency);
        assertIsMaxHeap(data);
    }
}
