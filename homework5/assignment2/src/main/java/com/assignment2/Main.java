package com.assignment2;

import java.util.Arrays;

public class Main {
    public static void countingSort(char[] arr) {

        int[] count = new int[26];

        for (char c : arr) {
            count[c - 'A']++;
        }

        System.out.println("Frequency Array:");
        System.out.println(Arrays.toString(count));

        for (int i = 1; i < 26; i++) {
            count[i] += count[i - 1];
        }

        System.out.println("Cumulative Count Array:");
        System.out.println(Arrays.toString(count));

        char[] output = new char[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int index = arr[i] - 'A';
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(output));
    }
    public static void main(String[] args) {
        char[] arr = {'A', 'A', 'Z', 'B', 'H', 'K', 'L', 'Z', 'W', 'X', 'P'};
        countingSort(arr);
    }
}