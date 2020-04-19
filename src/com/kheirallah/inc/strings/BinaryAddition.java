package com.kheirallah.inc.strings;

/*
Given two binary strings, return their sum (also a binary string).
The input strings are both non-empty and contains only characters 1 or 0.
Example 1:
Input: a = "11", b = "1"
Output: "100"
Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
 */
public class BinaryAddition {
    public static void main(String args[]) {
        String a = "11", b = "1";
        System.out.println(addBinary(a, b));
    }

    //Time O(N)
    //Space O(N)
    private static String addBinary(String a, String b) {
        if (a == null || b == null) return "";
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            carry = sum >> 1;
            sum = sum & 1;
            sb.append(sum == 0 ? '0' : '1');
        }
        if (carry > 0) sb.append('1');
        return sb.reverse().toString();
    }

    private static String addBinaryLibs(String a, String b) {
        int sum = Integer.parseInt(a, 2) + Integer.parseInt(b, 2);
        return Integer.toBinaryString(sum);
    }

}
