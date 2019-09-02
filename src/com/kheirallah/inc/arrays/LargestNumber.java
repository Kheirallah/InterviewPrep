package com.kheirallah.inc.arrays;

//Medium

/*
Given a list of non negative integers, arrange them such that they form the largest number

Example 1:
Input: [10, 2]
Output: “210”

Example 2:
Input: [3, 30, 34, 5, 9] Output: “9534330”

Note: The result may be very large, so you need to return a string instead of an integer
 */

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static void main(String[] args) {
        int[] input = {3, 30, 34, 5, 9};
        String output = largestNumber(input);
        System.out.println(output);
    }

    private static String largestNumber(int[] input) {
        String[] asStrs = new String[input.length];
        StringBuilder largestNum = new StringBuilder();

        //first we need to convert the input to strings
        for (int i = 0; i < input.length; i++) {
            asStrs[i] = String.valueOf(input[i]);
        }

        //We will need to modify the comparison to return the value that gives us a larger significant value
        //For example, 6 may be smaller then 58 as a number but 9658 is bigger than 9586 as a largest significant digit
        Arrays.sort(asStrs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1o2 = o1 + o2;
                String o2o1 = o2 + o1;
                //return the value that has the larger unicode value
                return o2o1.compareTo(o1o2);
            }
        });

        //the number is zero so no need to build the string
        if (asStrs[0].equals("0")) {
            return "0";
        }

        for (String value : asStrs) {
            largestNum.append(value);
        }

        return largestNum.toString();
    }
}

/*
Walkthrough

Example:
Input: [3, 30, 34, 5, 9] Output: “9534330”

Assuming input has been parsed to strings, we solve this problem by sorting the input with one caveat.
Take 53 vs 9 for example, a normal sort would return 53 as the larger value but 9 would give us a larger integer value. We need to sort by unicode value.


 */