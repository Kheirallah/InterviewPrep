package com.kheirallah.inc.google.arrays;

/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container and n is at least 2.

Example:
Input: [1,8,6,2,5,4,8,3,7]
Output: 49

https://leetcode.com/articles/container-with-most-water/#
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxAreaBruteForce(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxAreaTwoPointer(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    //Time O(n^2)
    //Space O(1)
    private static int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int currentMinHeight = Math.min(height[i], height[j]);
                int currentWidth = j - i;
                maxArea = Math.max(maxArea, currentMinHeight * currentWidth);
            }
        }
        return maxArea;
    }

    //Time O(n)
    //Space O(1)
    private static int maxAreaTwoPointer(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return maxArea;
    }
}
