package com.durpdur;

class Node {
    int key;
    Node next;

    Node(int key) {
        this.key = key;
        this.next = null;
    }
}

public class Main {
    public static Node listInsert(Node head, Node x) {
        x.next = head;
        return x;
    }

    public static Node listSearch(Node head, int key) {
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    public static Node listDelete(Node head, Node x) {
        if (head == null || x == null) {
            return head;
        }

        if (head == x) {
            return head.next;
        }

        Node current = head;

        while (current.next != null && current.next != x) {
            current = current.next;
        }

        if (current.next == x) {
            current.next = x.next;
        }

        return head;
    }

    private static Node left;

    public static boolean isListPalindrome(Node head) {
        left = head;
        return checkPalindrome(head);
    }

    private static boolean checkPalindrome(Node right) {
        if (right == null) {
            return true;
        }

        boolean result = checkPalindrome(right.next);

        if (!result) {
            return false;
        }

        boolean isEqual = (left.key == right.key);

        left = left.next;

        return isEqual;
    }

    public static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.key + " -> ");
            current = current.next;
        }
        
        System.out.println("null");
    }

    public static void main(String[] args) {
    }
}