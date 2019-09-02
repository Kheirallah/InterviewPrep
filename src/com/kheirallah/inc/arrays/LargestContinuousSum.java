package com.kheirallah.inc.arrays;

//Easy

/*
You are given an array of integers (both positive & negative). Find the continuous sequence with the largest sum. Return the sum.
Example: Input: {-2, -3, 4, -1, -2, 1, 5, -3} Output: 7, (4+-1+-2+1+5 = 7)
 */

public class LargestContinuousSum {

    public static void main(String[] args) {
        int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};
        int sum = maxSubArraySum(input);
        System.out.println(sum);
    }

    private static int maxSubArraySum(int[] input) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int i = 0; i < input.length; i++) {
            max_ending_here += input[i];
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }
}

/*
Walkthrough

Let’s take this example: {-2, -3, 4, -1, -2, 1, 5, -3}

Max_so_far = max_ending_here = 0
For I = 0, a[0] = -2

Max_ending_here = max_ending_here + (-2)
Set max_ending_here = 0 because max_ending_here < 0
For I = 1, a[1] = -3

Max_ending_here = max_ending_here + (-3)
Set max_ending_here = 0 because max_ending_here < 0
For I = 2, a[2] = 4

Max_ending_here = max_ending_here + (4) = 4
Max_so_far = 4 since 4 is greater than the previous value of 0
For I = 3, a[3] = -1

Max_ending_here = max_ending_here + (-1) = 3
For I = 4, a[4] = -2

Max_ending_here = max_ending_here + (-2) = 1
For I = 5, a[5] = 1

Max_ending_here = max_ending_here + (1) = 2
For I = 6, a[6] = 5

Max_ending_here = max_ending_here + (5) = 7
Max_so_far = 7 since 7 is larger than the previous value of 4
For I = 7, a[7] = -3

Max_ending_here = max_ending_here + (-3) = 4
Return max_so_far which is 7
 */