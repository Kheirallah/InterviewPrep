package com.kheirallah.inc.arrays;

//Hard

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.Example:
    Input: [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
 */

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int sum = findWaterTwoArrays(input);
        System.out.println(sum);
        sum = findWaterNoExtraSpace(input);
        System.out.println(sum);
    }

    /* Time Complexity: O(N) traverse through the length of input
        Space Complexity: O(N) two new arrays, same size as the input
     */
    private static int findWaterTwoArrays(int[] input) {
        int water = 0;
        int length = input.length;

        if (length < 1) {
            return 0;
        }

        //left[i] contains height of the tallest bar to the left of the ith bar including itself
        int left[] = new int[length];

        //right[i] contains height of the tallest bar to the right of the ith bar including itself
        int right[] = new int[length];

        left[0] = input[0];
        for (int i = 1; i < length; i++) {
            left[i] = Math.max(left[i - 1], input[i]);
        }

        right[length - 1] = input[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            right[i] = Math.max(input[i], right[i + 1]);
        }

        // Calculate the accumulated water element by element consider the amount of water on ith bar, the amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - input[i]
        for (int i = 0; i < length; i++) {
            water += Math.min(left[i], right[i]) - input[i];
        }

        return water;
    }

    /* Time Complexity: O(N) traverse through the length of input
        Space Complexity: O(1) no new data structures
     */
    private static int findWaterNoExtraSpace(int[] input) {
        int length = input.length;
        int water = 0;

        //max elements from each side
        int left_max = 0;
        int right_max = 0;

        //Indices
        int lo = 0;
        int hi = length - 1;

        while (lo <= hi) {
            if (input[lo] < input[hi]) {
                if (input[lo] > left_max) {
                    //update max to left
                    left_max = input[lo];
                } else {
                    //water on curr element = max - curr
                    water += left_max - input[lo];
                    lo++;
                }
            } else {
                if (input[hi] > right_max) {
                    //update right max
                    right_max = input[hi];
                } else {
                    water += right_max - input[hi];
                    hi--;
                }
            }
        }

        return water;
    }


}