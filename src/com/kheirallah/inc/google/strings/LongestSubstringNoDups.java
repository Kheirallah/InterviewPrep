package com.kheirallah.inc.google.strings;

import java.util.HashMap;
import java.util.Map;

/*
Given a string, find the length of the longest substring without repeating characters.
Example 1:
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringNoDups {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    //Time O(N)
    //Space O(N)
    private static int lengthOfLongestSubstring(String s) {
        int count = 0, start = 0;
        Map<Character, Integer> usedCharsIndices = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (usedCharsIndices.containsKey(c) && usedCharsIndices.get(c) >= start) {
                start = usedCharsIndices.get(c) + 1;
            }
            count = Math.max(count, i - start + 1);
            usedCharsIndices.put(c, i);
        }
        return count;
    }
}
