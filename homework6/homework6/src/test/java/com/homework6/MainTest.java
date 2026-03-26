package com.homework6;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void testPrimMSTOnSampleGraph() {
        Main.Graph graph = new Main.Graph(5);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        Main.PrimResult result = Main.primMST(graph, 0);

        assertArrayEquals(new int[] { -1, 0, 1, 0, 1 }, result.parent);
        assertArrayEquals(new int[] { 0, 2, 3, 6, 5 }, result.key);
        assertEquals(4, result.mstEdges.size());
        assertEquals(16, result.totalWeight);
    }

    @Test
    void testPrimMSTSingleVertex() {
        Main.Graph graph = new Main.Graph(1);

        Main.PrimResult result = Main.primMST(graph, 0);

        assertArrayEquals(new int[] { -1 }, result.parent);
        assertArrayEquals(new int[] { 0 }, result.key);
        assertEquals(0, result.mstEdges.size());
        assertEquals(0, result.totalWeight);
    }

    @Test
    void testInvalidStartVertexThrows() {
        Main.Graph graph = new Main.Graph(3);

        assertThrows(IllegalArgumentException.class, () -> Main.primMST(graph, -1));
        assertThrows(IllegalArgumentException.class, () -> Main.primMST(graph, 3));
    }

    @Test
    void testInvalidEdgeThrows() {
        Main.Graph graph = new Main.Graph(3);

        assertThrows(IllegalArgumentException.class, () -> graph.addEdge(0, 3, 10));
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge(-1, 2, 5));
    }
}