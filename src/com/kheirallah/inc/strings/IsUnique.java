package com.kheirallah.inc.strings;

import java.util.HashSet;
import java.util.Set;

//Easy
//Crack the coding interview 1.1

/*
Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures.

Example:
    Input: "abcde"
    Output: true

    Input: "aabb"
    Output: false
 */
public class IsUnique {

    //By using an additional data structure, a HashSet is great for this purpose with constant lookup times
    //Time complexity O(n), Space complexity O(n)
    private static boolean isUnique(String input) {
        Set<Character> charSet = new HashSet<>();

        for (char c : input.toCharArray()) {
            //if the set already contains the character then we know that it is a unique string
            if (charSet.contains(c)) {
                return false;
            } else {
                charSet.add(c);
            }
        }

        return true;
    }

    //without an additional data structure, iterate through the string twice, first to get a character, second to check that the char doesnt exist in the rest of the string
    //Time complexity O(n^2)
    //Space complexity O(1) constant, since there is no new data structures
    private static boolean isUniqueNoExtraStructures(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == c && i != j) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "abcde";
        System.out.println(isUnique(input));
        System.out.println(isUniqueNoExtraStructures(input));
    }
}
