package com.homework6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static class Edge {
        final int to;
        final int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class MSTEdge {
        int from;
        int to;
        int weight;

        MSTEdge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
        return (char) ('a' + from) + " - " + (char) ('a' + to) + " (" + weight + ")";        }
    }

    static class Node {
        final int vertex;
        final int key;

        Node(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }
    }

    static class Graph {
        private final int vertices;
        private final List<List<Edge>> adj;

        Graph(int vertices) {
            if (vertices <= 0) {
                throw new IllegalArgumentException("Number of vertices must be positive.");
            }
            this.vertices = vertices;
            this.adj = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v, int weight) {
            validateVertex(u);
            validateVertex(v);
            adj.get(u).add(new Edge(v, weight));
            adj.get(v).add(new Edge(u, weight));
        }

        int getVertices() {
            return vertices;
        }

        List<Edge> neighbors(int vertex) {
            validateVertex(vertex);
            return adj.get(vertex);
        }

        private void validateVertex(int v) {
            if (v < 0 || v >= vertices) {
                throw new IllegalArgumentException("Invalid vertex: " + v);
            }
        }
    }

    static class PrimResult {
        final int[] parent;
        final int[] key;
        final List<MSTEdge> mstEdges;
        final int totalWeight;

        PrimResult(int[] parent, int[] key, List<MSTEdge> mstEdges, int totalWeight) {
            this.parent = parent;
            this.key = key;
            this.mstEdges = mstEdges;
            this.totalWeight = totalWeight;
        }
    }

    public static PrimResult primMST(Graph graph, int startVertex) {
        int n = graph.getVertices();
        if (startVertex < 0 || startVertex >= n) {
            throw new IllegalArgumentException("Invalid start vertex: " + startVertex);
        }

        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] inMST = new boolean[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.key));

        key[startVertex] = 0;
        minHeap.offer(new Node(startVertex, 0));

        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();
            int u = current.vertex;

            if (inMST[u]) {
                continue;
            }

            inMST[u] = true;

            for (Edge edge : graph.neighbors(u)) {
                int v = edge.to;
                int weight = edge.weight;

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    minHeap.offer(new Node(v, key[v]));
                }
            }
        }

        List<MSTEdge> mstEdges = new ArrayList<>();
        int totalWeight = 0;

        for (int v = 0; v < n; v++) {
            if (parent[v] != -1) {
                mstEdges.add(new MSTEdge(parent[v], v, key[v]));
                totalWeight += key[v];
            }
        }

        return new PrimResult(parent, key, mstEdges, totalWeight);
    }

    // Part 2: separate method to print the MST clearly
    public static void printMST(PrimResult result) {
        System.out.println("Minimum Spanning Tree edges:");
        for (MSTEdge edge : result.mstEdges) {
            System.out.println(edge);
        }
        System.out.println("Total weight: " + result.totalWeight);
    }

    /********************************
    Printed Results:
    ---------------------------------
    Parent array: [-1, 0, 5, 2, 3, 6, 7, 0, 2]
    Key array: [0, 4, 4, 7, 9, 2, 1, 8, 2]
    Minimum Spanning Tree edges:
    a - b (4)
    f - c (4)
    c - d (7)
    d - e (9)
    g - f (2)
    h - g (1)
    a - h (8)
    c - i (2)
    Total weight: 37
    ********************************/
    public static void main(String[] args) {
        Graph graph = new Graph(9);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);

        PrimResult result = primMST(graph, 0);

        System.out.println("Parent array: " + Arrays.toString(result.parent));
        System.out.println("Key array: " + Arrays.toString(result.key));
        printMST(result);
    }
}