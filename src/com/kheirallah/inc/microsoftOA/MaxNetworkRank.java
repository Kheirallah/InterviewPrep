package com.kheirallah.inc.microsoftOA;

/*
An infrastructure consisting of N cities, numbered from 1 to N, and M bidirectional roads between them is given. Roads do not intersect apart from at thheir start and end points
(they can pass through underground tunnels to avoid collisions)

For each pair of cities directly connected by a road, lets define their network rank as the total number of roads that are connected to either of the two cities.

Write a function:
    class Solution { public int solution(int[] A, int[] B, int N); }
that, given two arrays A,B consisting of M integers each and an integer N, where A[i] and B[i] are cities at the two ends of the i-th road, returns the maximal network rank in the whole
infrastructure.

Examples:
1. Given A = [1,2,3,3], B = [2,3,1,4] and N = 4, the function should return 4. The chosen cities may be 2 and 3, and the four roads connected to them are:
(2,1),(2,3),(3,1),(3,4).
 */
public class MaxNetworkRank {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        int[] B = new int[]{2, 3, 1, 4};
        System.out.println(maxNetworkRank(A, B, 4));
    }

    //Time O(N)
    //Space O(N)
    private static int maxNetworkRank(int[] A, int[] B, int N) {
        int max = 0;
        int[] edgeCount = new int[N + 1];

        for (int i = 0; i < N; i++) {
            edgeCount[A[i]] += 1;
            edgeCount[B[i]] += 1;
        }

        for (int i = 0; i < N; i++) {
            int localMax = edgeCount[A[i]] + edgeCount[B[i]] - 1;
            max = Math.max(max, localMax);
        }

        return max;
    }
}
