package com.kheirallah.inc.strings;

//Easy
//Crack the coding interview 1.3

/*
Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold
the additional characters, and that you are given the "true" length of the string. (Note: If implementing in Java, please use a character array
so that you can perform this operation in place."

Example:
    Input: "Mr John Smith     ", 13
    Output: "Mr%20John%20Smith"
 */
public class URLify {

    //Time complexity O(n) as we only iterate through the same array twice
    //Space complexity O(1), no new data structures needed

    private static String urlIfy(char[] input, int trueLength) {
        int spaceCount = 0, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (input[i] == ' ') {
                spaceCount++;
            }
        }
        int index = trueLength + spaceCount * 2;
        for (i = trueLength - 1; i >= 0; i--) {
            if (input[i] == ' ') {
                input[index - 3] = '%';
                input[index - 2] = '2';
                input[index - 1] = '0';
                index = index - 3;
            } else {
                input[index - 1] = input[i];
                index--;
            }
        }
        return String.valueOf(input);
    }


    public static void main(String[] args) {
        String input = "Mr Kheirallah Ashkar    ";
        System.out.println(urlIfy(input.toCharArray(), 20));
    }
}
