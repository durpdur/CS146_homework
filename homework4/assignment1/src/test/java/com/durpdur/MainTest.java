package com.durpdur;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private Node[] buildSampleList() {
        Node head = null;

        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);

        head = Main.listInsert(head, node1);
        head = Main.listInsert(head, node2);
        head = Main.listInsert(head, node3);

        return new Node[]{head, node1, node2, node3};
    }

    private String listToString(Node head) {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            sb.append(cur.key).append(" -> ");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }

    @Test
    void testListInsertOrder() {
        Node[] arr = buildSampleList();
        Node head = arr[0];

        assertEquals("30 -> 20 -> 10 -> null", listToString(head));
        assertEquals(30, head.key);
        assertNotNull(head.next);
        assertEquals(20, head.next.key);
        assertNotNull(head.next.next);
        assertEquals(10, head.next.next.key);
    }

    @Test
    void testListSearchFound() {
        Node[] arr = buildSampleList();
        Node head = arr[0];

        Node found = Main.listSearch(head, 20);
        assertNotNull(found);
        assertEquals(20, found.key);
    }

    @Test
    void testListSearchNotFound() {
        Node[] arr = buildSampleList();
        Node head = arr[0];

        Node found = Main.listSearch(head, 99);
        assertNull(found);
    }

    @Test
    void testListDeleteMiddleNode() {
        Node[] arr = buildSampleList();
        Node head = arr[0];
        Node node2 = arr[2];

        head = Main.listDelete(head, node2);

        assertEquals("30 -> 10 -> null", listToString(head));
    }

    @Test
    void testListDeleteNodeNotInListDoesNothing() {
        Node[] arr = buildSampleList();
        Node head = arr[0];

        Node notInList = new Node(999);
        Node newHead = Main.listDelete(head, notInList);


        assertEquals("30 -> 20 -> 10 -> null", listToString(newHead));
    }

    @Test
    void testDeleteNullOrEmptyListSafe() {
        Node head = null;

        head = Main.listDelete(head, new Node(1));
        assertNull(head);

        Node one = new Node(1);
        head = Main.listInsert(null, one);
        Node after = Main.listDelete(head, null);
        assertEquals("1 -> null", listToString(after));
    }
}