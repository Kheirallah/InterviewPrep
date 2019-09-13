package com.kheirallah.inc.strings;

//Easy
//Crack the coding interview 1.5

/*
There are three types of edits that can be performed on strings: insert, remove, & replace a character. Given two strings, write a function
to check if they are one edit away (or zero edits) away.

Example:
    Input: "pale", "ple"
    Output: True

    Input: "pales", "pale"
    Output: True

    Input: "pale", "bale"
    Output: True

    Input: "pale", "bake"
    Output: False
 */
public class OneAway {

    //Time complexity O(n) as we only iterate through strings of equal length within the range of 1 once
    //Space complexity O(1), no new data structures needed

    private static Boolean isOneEditAway(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return replacement(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            return edit(s1, s2);
        } else if (s1.length() - 1 == s2.length()) {
            return edit(s2, s1);
        }
        return false;
    }

    private static Boolean edit(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }

        return true;
    }

    private static Boolean replacement(String s1, String s2) {
        boolean foundOnce = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundOnce) {
                    return false;
                }
                foundOnce = true;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String input = "pale";
        String input2 = "ple";
        System.out.println(isOneEditAway(input, input2));
    }
}
