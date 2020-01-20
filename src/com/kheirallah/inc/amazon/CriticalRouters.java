package com.kheirallah.inc.amazon;

/*
You are given an undirected connected graph. An articulation point (or cut vertex) is defined as a vertex which, when removed along with associated edges, makes the graph disconnected (or more precisely, increases the number of connected components in the graph). The task is to find all articulation points in the given graph.

Input:
The input to the function/method consists of three arguments:

numNodes, an integer representing the number of nodes in the graph.
numEdges, an integer representing the number of edges in the graph.
edges, the list of pair of integers - A, B representing an edge between the nodes A and B.
Output:
Return a list of integers representing the critical nodes.

Example:

Input: numNodes = 7, numEdges = 7, edges = [[0, 1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3, 4]]
Output: [2, 3, 5]
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CriticalRouters {

    //Time Complexity O(vertices * edges)
    private static List<Integer> criticalNodes(int[][] edges, int numNodes, int numEdges) {
        List<Integer> criticalNodes = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            HashSet<Integer> visitedNodes = new HashSet<>();
            boolean firstAdd = false;
            for (int j = 0; j < numEdges; j++) {
                //ignore edges that have the starting node as a starting or ending point
                if (edges[j][0] == i || edges[j][1] == i) {
                    continue;
                }
                //adding any edge as the starting point, both vertices will fail if the edges are self edges
                if (!firstAdd) {
                    visitedNodes.add(edges[j][0]);
                    visitedNodes.add(edges[j][1]);
                    firstAdd = true;
                }
                //if the next edge has one of the edges already in the set of visitedNodes, I can visit it
                if (visitedNodes.contains(edges[j][0]) || visitedNodes.contains(edges[j][1])) {
                    visitedNodes.add(edges[j][0]);
                    visitedNodes.add(edges[j][1]);
                }
            }
            if (visitedNodes.size() != numNodes - 1) {
                criticalNodes.add(i);
            }
        }
        return criticalNodes;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1},
                {0, 2},
                {1, 3},
                {2, 3},
                {2, 5},
                {5, 6},
                {3, 4}};
        for (int[] edge : edges) {
            for (Integer value : edge) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        int numNodes = 7; //amount of vertices or routers in this case
        int numEdges = 7;

        System.out.println(criticalNodes(edges, numNodes, numEdges));
    }
}
