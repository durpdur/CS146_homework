package com.durpdur;

class WordFreq {
    String word;
    int frequency;

    public WordFreq(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}

class MaxHeap {
    WordFreq[] arr;
    int n;

    public MaxHeap(WordFreq[] arr) {
        this.arr = arr;
        this.n = arr.length;
    }

    public void buildMaxHeap() {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    private void maxHeapify(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left].frequency > arr[largest].frequency) {
            largest = left;
        }

        if (right < n && arr[right].frequency > arr[largest].frequency) {
            largest = right;
        }

        if (largest != i) {
            WordFreq temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify(largest);
        }
    }

}

public class Main {
    public static void main(String[] args) {
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
    }
}
