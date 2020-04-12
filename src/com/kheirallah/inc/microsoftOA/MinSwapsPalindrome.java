package com.kheirallah.inc.microsoftOA;

import java.util.HashSet;
import java.util.Set;

/*
Given a string, what is the minimum number of adjacent swaps required to convert a string into a palindrome. If not possible, return -1.
 */
public class MinSwapsPalindrome {

    public static void main(String[] args) {
        System.out.println(minSwapsNeeded("mamad"));
        System.out.println(minSwapsNeeded("asflkj"));
        System.out.println(minSwapsNeeded("aabb"));
    }

    private static int minSwapsNeeded(String input) {
        char[] s = input.toCharArray();
        int swapsNeeded = 0;
        if (!isPalindrome(input)) {
            return -1;
        }
        int i = 0;
        int j = s.length - 1;
        int k = j;
        while (i < j) {
            k = j;
            while (s[i] != s[k] && k > i) {
                k--;
            }
            if (s[i] == s[k] && i != k) {
                while (k < j) {
                    swap(s, k, k + 1);
                    k++;
                    swapsNeeded++;
                }
                i++;
                j--;
            } else {
                swap(s, i, i + 1);
                swapsNeeded++;
            }
        }
        return swapsNeeded;
    }

    private static boolean isPalindrome(String input) {
        Set<Character> usedChars = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (usedChars.contains(c)) {
                usedChars.remove(c);
            } else {
                usedChars.add(c);
            }
        }
        return usedChars.size() < 2;
    }

    private static void swap(char[] input, int i, int j) {
        char tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}
