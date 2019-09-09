package com.kheirallah.inc.strings;

//Medium
//Crack the coding interview 1.4

/*
Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase
that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited
to just dictionary words.

 Example 1
    Input: "Tact Coa"
    Output: True
    (permutations: "taco cat", "atco cta", etc....)
 */
public class PalindromePermutation {

    //Time Complexity O(N)
    //Space complexity O(N) in order to maintain the character table
    private static boolean palindromePermutation(String input) {
        int[] table = new int[26];
        for (char c : input.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    private static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    public static void main(String[] args) {
        String input = "Tact Coa";
        System.out.println(palindromePermutation(input));
    }
}
