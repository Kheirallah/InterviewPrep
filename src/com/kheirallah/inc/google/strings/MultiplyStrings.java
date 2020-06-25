package com.kheirallah.inc.google.strings;

/*
https://leetcode.com/explore/interview/card/google/59/array-and-strings/3051/
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

        Example 1:

        Input: num1 = "2", num2 = "3"
        Output: "6"
        Example 2:

        Input: num1 = "123", num2 = "456"
        Output: "56088"
        Note:

        The length of both num1 and num2 is < 110.
        Both num1 and num2 contain only digits 0-9.
        Both num1 and num2 do not contain any leading zero, except the number 0 itself.
        You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));
    }

    //Time O(N*K) where n is num1 length and K is num2 length
    //Space O(N) for the product being returned
    public static String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) {
            return "0";
        }
        String res = getResult(num1, num2);
        return res.length() > 0 ? res : "0";
    }

    private static String getResult(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        int carry = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            carry = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int n1 = Character.getNumericValue(num1.charAt(j));
                int n2 = Character.getNumericValue(num2.charAt(i));
                int mul = result[i + j + 1] + (n1 * n2) + carry;
                result[i + j + 1] = mul % 10;
                carry = mul / 10;
            }
            result[i] = carry;
        }
        StringBuilder sb = new StringBuilder();
        boolean numStart = false;
        int k = 0;

        while (k < result.length) {
            if (result[k] > 0) break;
            k++;
        }

        while (k < result.length) {
            sb.append(result[k]);
            k++;
        }
        return sb.toString();
    }
}
