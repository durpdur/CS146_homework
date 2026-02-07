package com.durpdur;

import java.util.Arrays;

public class Main {
    static int[] mergeArr(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0;
        int j = 0;
        int n = arr1.length;
        int m = arr2.length;
        int[] mergedArr= new int[n + m];
        
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                mergedArr[i + j] = arr1[i];
                i++;
            } else {
                mergedArr[i + j] = arr2[j];
                j++;
            }
        }

        while (i < n) mergedArr[i + j] = arr1[i++];
        while (j < m) mergedArr[i + j] = arr2[j++];

        return mergedArr;
    }

    public static void main(String[] args) {
    }
}