package com.kheirallah.inc.arrays;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/articles/minimum-window-substring/#

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:
If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubString {
    public static void main(String[] args) {
        System.out.println(minWindow("ABAACBAB", "ABC"));
    }

    //Time, Space O(S + T)
    private static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        //Dictionary which keeps a count of all the unique characters in t
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        //number of unique chars in t
        int required = dictT.size();

        int l = 0, r = 0;

        //formed is used to keep track of how many unique characters in t are present in the current window
        int formed = 0;

        //keeps count of all the unique characters in the current window
        Map<Character, Integer> windowCounts = new HashMap<>();

        //ans list of the form {-1, 0, 0};
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) formed++;

            while (l <= r && formed == required) {
                c = s.charAt(l);
                //saving the smallest window
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                //character at L is no longer part of the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) formed--;

                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
