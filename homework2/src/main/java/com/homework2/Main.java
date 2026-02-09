package com.homework2;

public class Main {
    static int lomotoPartition(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        
        int n = arr.length - 1;
        int i = -1;
        int pivot = arr[n];

        for (int j = 0; j < n; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[n];
        arr[n] = temp;

        return i + 1;
    }

    static int hoarePartition(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int l = -1;
        int r = arr.length;

        int pivot = arr[0];

        while (true) {
            do { l++; } while (arr[l] < pivot);

            do { r--; } while (arr[r] > pivot);

            if (l >= r) return r;

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
    }

    public static void main(String[] args) {}
}