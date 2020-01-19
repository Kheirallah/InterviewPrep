package com.kheirallah.inc.arrays;

//Easy

/*
You are given an array of integers, find the continuous sequence with the largest sum. Return the sum.
Example:
    Input: {-2, -3, 4, -1, -2, 1, 5, -3}
    Output: 7, (4+-1+-2+1+5 = 7)
 */

public class LargestContinuousSum {

    public static void main(String[] args) {
        int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};
        int sum = maxSubArraySum(input);
        System.out.println(sum);
    }

    //Time complexity O(n)
    //Space complexity O(1)
    private static int maxSubArraySum(int[] input) {
        int globalMax = Integer.MIN_VALUE;
        int localMax = 0;

        for (int value : input) {
            localMax = Math.max(localMax, value + localMax);
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        return globalMax;
    }
}