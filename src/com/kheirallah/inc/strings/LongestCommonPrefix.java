package com.kheirallah.inc.strings;

/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Example 1:
Input: ["flower","flow","flight"]
Output: "fl"
Example 2:
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:
All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {
    public static void main(String args[]) {
        String[] values = new String[]{"flower", "flow", "flight"};
        String[] values2 = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(values));
        System.out.println(longestCommonPrefix(values2));
    }

    //Time O(N) where N is the sum of all characters across all strings
    //Space O(1)
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
