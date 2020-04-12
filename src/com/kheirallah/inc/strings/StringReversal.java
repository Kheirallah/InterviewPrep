package com.kheirallah.inc.strings;

/*
Write a function that reverses a string. The input string is given as an array of characters char[].
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
You may assume all the characters consist of printable ascii characters.

Example 1:
Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
 */
public class StringReversal {
    public static void main(String[] args) {
        String s = "hello";
        char[] s2 = reverseString(s.toCharArray());
        for (char c : s2) {
            System.out.println(c);
        }
    }

    private static char[] reverseString(char[] s) {
        int end = s.length - 1;
        for (int i = 0; i < end; i++) {
            swap(i, end, s);
            end--;
        }
        return s;
    }

    private static void swap(int one, int two, char[] s) {
        char temp = s[one];
        s[one] = s[two];
        s[two] = temp;
    }
}
