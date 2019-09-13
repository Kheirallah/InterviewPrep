package com.kheirallah.inc.strings;

//Easy
//Crack the coding interview 1.6

/*
Implement a method to perform basic string compression using the counts of repeated characters. If the "compressed" string would not
be smaller than the original than return the original string. You can assume the string has only uppercase and lowercase letters (a-z)

Example:
    Input: "aabcccccaaa"
    Output: "a2b1c5a3"
 */
public class StringCompression {

    //Time complexity O(n) as we only iterate through the input string
    //Space complexity O(n), a new string needs to be returned

    private static String stringCompress(String input) {
        StringBuilder sb = new StringBuilder();
        int countOccurences = 0;
        for (int i = 0; i < input.length(); i++) {
            countOccurences++;
            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                sb.append(input.charAt(i));
                sb.append(countOccurences);
                countOccurences = 0;
            }
        }
        return sb.length() < input.length() ? sb.toString() : input;
    }

    public static void main(String[] args) {
        String input = "aabcccccaaa";
        System.out.println(stringCompress(input));
    }
}
