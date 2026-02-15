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

        
    }
}