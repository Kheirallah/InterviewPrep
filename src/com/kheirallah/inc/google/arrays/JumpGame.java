package com.kheirallah.inc.google.arrays;

public class JumpGame {
    /*
    https://leetcode.com/articles/jump-game/#
    Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Determine if you are able to reach the last index.

    Example 1:
    Input: nums = [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
    Example 2:
    Input: nums = [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

    Constraints:
    1 <= nums.length <= 3 * 10^4
    0 <= nums[i][j] <= 10^5
     */
    public static void main(String[] args) {
        System.out.println(canJumpFromPositionBacktracking(0, new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJumpDynamicBottomUp(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJumpDPBottomUpIteration(new int[]{2, 3, 1, 1, 4}));
    }

    //Time O(2^N)
    //Space O(1)
    private static boolean canJumpFromPositionBacktracking(int position, int[] nums) {
        if (position == nums.length - 1) return true;
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPositionBacktracking(nextPosition, nums)) return true;
        }
        return false;
    }

    enum Index {
        GOOD, BAD, UNKNOWN
    }


    /*
        Time complexity :
        O(n^2)
        For every element in the array, say i, we are looking at the next nums[i] elements to its right aiming to find a GOOD index. nums[i] can be at most
        n, where n is the length of array nums.
        Space complexity :
        O(2n)=O(n). First n originates from recursion. Second n comes from the usage of the memo table.
     */
    public static boolean canJumpDynamicBottomUp(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) memo[i] = Index.UNKNOWN;
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPositionDynamicBottomUp(0, nums, memo);
    }

    private static boolean canJumpFromPositionDynamicBottomUp(int position, int[] nums, Index[] memo) {
        if (memo[position] != Index.UNKNOWN) return memo[position] == Index.GOOD;
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPositionDynamicBottomUp(nextPosition, nums, memo)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }

    /*
    Time complexity :
    O(n^2) For every element in the array, say i, we are looking at the next nums[i] elements to its right aiming to find a GOOD index. nums[i] can be at most n, where
    n is the length of array nums.
    Space complexity :
    O(n). This comes from the usage of the memo table.
     */
    public static boolean canJumpDPBottomUpIteration(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) memo[i] = Index.UNKNOWN;
        memo[memo.length - 1] = Index.GOOD;
        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }

    //Time O(N), single pass through nums
    //Space O(1)
    public static boolean canJumpGreedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) lastPos = i;
        }
        return lastPos == 0;
    }
}
