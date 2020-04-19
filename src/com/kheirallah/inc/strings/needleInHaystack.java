package com.kheirallah.inc.strings;

/*
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1
 */
public class needleInHaystack {
    public static void main(String args[]) {
        String haystack = "mississippi", needle = "issippi";
        System.out.println(findNeedleIndex(haystack, needle));
    }

    //Time O(N) because needle must always be within the range of the length of the haystack or no comparisons are made
    //Space O(N)
    private static int findNeedleIndex(String haystack, String needle) {
        if (needle.isEmpty() || needle == null) return 0;
        if (needle.length() > haystack.length()) return -1;

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean found = true;
                int first = i;
                for (char c : needle.toCharArray()) {
                    if (first >= haystack.length()) {
                        found = false;
                        break;
                    }
                    if (c != haystack.charAt(first++)) {
                        found = false;
                        break;
                    }
                }
                if (found) return i;
            }
        }
        return -1;
    }
}
