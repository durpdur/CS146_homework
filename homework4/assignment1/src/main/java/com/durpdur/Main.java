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

    public static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.key + " -> ");
            current = current.next;
        }
        
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = null;

        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);

        head = listInsert(head, node1);
        head = listInsert(head, node2);
        head = listInsert(head, node3);

        System.out.println("Linked List:");
        printList(head);

        int searchKey = 20;
        Node found = listSearch(head, searchKey);

        if (found != null) {
            System.out.println("Node[" + searchKey + "] found.");
        } else {
            System.out.println("Node[" + searchKey + "] not found.");
        }

        head = listDelete(head, node2);

        System.out.println("List after deletion:");
        printList(head);
    }
}