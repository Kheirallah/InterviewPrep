package com.kheirallah.inc.strings;

//Easy
//Crack the coding interview 1.2

/*
Given two strings, write a method to check if one is a permutation of the other

 Example 1
    Input: "abcd", "dabc"
    Output: true

 Example 2
    Input: "dog" "wof"
    Output: false
 */
public class checkPermutation {

    //Time Complexity O(N)
    //Space complexity O(N), for positions tracking array
    private static boolean checkPermutation(String input1, String input2) {
        //permutations have to be the same length
        if (input1.length() != input2.length()) {
            return false;
        }

        //can be made shorter if only counting english alphabet letters to be of size 26
        int[] charPositions = new int[128]; //Assuming ASCII values

        for (char c : input1.toCharArray()) {
            charPositions[c]++; //or charPositions[c - 'a'] if only using english characters
        }

        for (char c : input2.toCharArray()) {
            charPositions[c]--;
            if (charPositions[c] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String input1 = "dog";
        String input2 = "god";
        System.out.println(checkPermutation(input1, input2));
    }
}
