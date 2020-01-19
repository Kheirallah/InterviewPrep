package com.kheirallah.inc.arrays;

//Easy

/*
Given a non-empty array of digits representing a non-negative integer, add one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zeroes, except for the number 0 itself.

Example 1:
    Input: [1, 2, 3]
    Output: [1, 2, 4]

Example 2:
    Input: [4, 3, 2, 1]
    Output: [4, 3, 2, 2]
 */

public class PlusOne {

    public static void main(String[] args) {
        int[] input = {4, 3, 2, 1};
        int[] output = plusOne(input);
        for (int value : output) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1] += 1;
            return digits;
        } else {
            int i = digits.length - 1;
            while (digits[i] == 9) {
                if (i == 0) {
                    int[] newArr = new int[digits.length + 1];
                    newArr[0] = 1;
                }
                digits[i] = 0;
                i--;
            }
            digits[i] += 1;
            return digits;
        }

    }
}
