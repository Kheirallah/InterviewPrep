package com.kheirallah.inc.google.arrays;

import java.util.*;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note:
The solution set must not contain duplicate triplets.
Example:
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

https://leetcode.com/articles/3sum/#
 */
public class ThreeSum {
    public static void main(String args[]) {
        System.out.println(threesumTwoPointer(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threesumSet(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threesumSetOptimized(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    private static List<List<Integer>> threesumSet(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Pair> found = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < nums.length; ++j) {
                int complement = -nums[i] - nums[j];
                if (seen.contains(complement)) {
                    int v1 = Math.min(nums[i], Math.min(complement, nums[j]));
                    int v2 = Math.max(nums[i], Math.max(complement, nums[j]));
                    if (found.add(new Pair(v1, v2)))
                        res.add(Arrays.asList(nums[i], complement, nums[j]));
                }
                seen.add(nums[j]);
            }
        }
        return res;
    }

    /*
    Optimized Algorithm
    These optimizations don't change the big-O complexity, but help speed things up: 1. Use another hash set dups to skip duplicates in the outer loop. 2. Instead of re-populating a hash set every time in the inner loop, we can populate a hashmap once and then only modify values. After we process nums[j] in the inner loop, we set the hashmap value to i.
    This indicates that we can now use nums[j] to find pairs for nums[i].

     Time O(n^2)
     Space O(n^2)
     */
    private static List<List<Integer>> threesumSetOptimized(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Pair> found = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i]))
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        int v1 = Math.min(nums[i], Math.min(complement, nums[j]));
                        int v2 = Math.max(nums[i], Math.max(complement, nums[j]));
                        if (found.add(new Pair(v1, v2)))
                            res.add(Arrays.asList(nums[i], complement, nums[j]));
                    }
                    seen.put(nums[j], i);
                }
        return res;
    }

    //Time O(n^2) n for twoSumII and nlogn for sorting
    //Space (nlogn or n) depends on sort, + n^2 for the output 2d list
    private static List<List<Integer>> threesumTwoPointer(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) twoSumII(nums, i, res);
        }
        return res;
    }

    private static void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0 || (lo > i + 1 && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (sum > 0 || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
            }
        }
    }

    private static class Pair {
        private int value;
        private int value2;

        public Pair(int value, int value2) {
            this.value = value;
            this.value2 = value2;
        }
    }


}
