package com.durpdur;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    void testPalindromeTestCase1() {
        Node head = null;

        head = Main.listInsert(head, new Node(1));
        head = Main.listInsert(head, new Node(2));
        head = Main.listInsert(head, new Node(3));
        head = Main.listInsert(head, new Node(2));
        head = Main.listInsert(head, new Node(1));

        assertTrue(Main.isListPalindrome(head));
    }

    @Test
    void testPalindromeTestCase2() {
        Node head = null;

        head = Main.listInsert(head, new Node(10));
        head = Main.listInsert(head, new Node(20));
        head = Main.listInsert(head, new Node(20));
        head = Main.listInsert(head, new Node(10));

        assertTrue(Main.isListPalindrome(head));
    }

    @Test
    void testNotPalindrome() {
        Node head = null;

        head = Main.listInsert(head, new Node(17));
        head = Main.listInsert(head, new Node(10));
        head = Main.listInsert(head, new Node(5));

        assertFalse(Main.isListPalindrome(head));
    }
}