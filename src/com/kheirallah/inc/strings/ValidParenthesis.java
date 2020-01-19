package com.kheirallah.inc.strings;

//Easy

/*
Given a string containing just the characters ‘(‘, ‘)’, ‘{‘, ‘}’, ‘[‘, and ‘]’, determine if the input string is valid.

An input string is valid if:
1. Open brackets must be closed by the same type of brackets
2. Open brackets must be closed in the correct order

Note that an empty string is also considered valid.

Example 1: Input: “()”
Output: true

Example 2: Input: “()[]{}”
Output: true

Example 3: Input: “(]”
Output: false

Example 4: Input: “([)]”
Output: false

Example 5: Input: “{[]}”
Output: true
 */

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        String input = "{()}";

        System.out.println(isValidParenthesis(input));
    }

    //Time Complexity O(n)
    //Space Complexity O(n), for new stack
    //{[]}
    //
    private static boolean isValidParenthesis(String input) {
        Stack<Character> characters = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '{') {
                characters.push('}');
            } else if (c == '[') {
                characters.push(']');
            } else if (c == '(') {
                characters.push(')');
            } else if (characters.isEmpty() || characters.pop() != c) {
                return false;
            }
        }
        return characters.isEmpty();
    }
}
