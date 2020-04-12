package com.kheirallah.inc.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of intervals, merge all overlapping intervals.
Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(intervals);
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int startIndex = 0;
        int endIndex = 0;
        List<int[]> result = new ArrayList<>();
        while (endIndex < n) {
            if (endIndex == n - 1 || starts[endIndex + 1] > ends[endIndex]) {
                result.add(new int[]{starts[startIndex], ends[endIndex]});
                startIndex = endIndex + 1;
            }
            endIndex++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
