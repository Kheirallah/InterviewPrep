package com.kheirallah.inc.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private int v;

    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        this.v = v;
    }

    public void addEdge(int v, int e) {
        adj[v].add(e);
    }

    public void DFS(int startingPoint) {
        boolean[] visited = new boolean[v];
        DFSUtil(startingPoint, visited);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(v);
        for (int edge : adj[v]) {
            if (!visited[edge]) {
                DFSUtil(edge, visited);
            }
        }
    }

    public void BFS(int s) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.println(s);
            for (int edge : adj[s]) {
                if (!visited[edge]) {
                    visited[edge] = true;
                    queue.add(edge);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.BFS(2);
    }
}