package com.kheirallah.inc.stacks;

//Medium
//Crack the coding interview 3.5

/*
Write a program to sort a stack such that the smallest items are on top. You can use an additional temp stack, but you may not copy the elements into any other data structure
(such as an array). The stack supports the following operations: push, pop, peek, and isEmpty

Example
    Input: 2, 9, 4, 5, 1 (Stack) (top to bottom)
    Output: 1, 2, 4, 5, 9 (Stack) (top to bottom)
 */

import java.util.Stack;

public class SortStack {


    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(5);
        s.push(4);
        s.push(9);
        s.push(2);
        sort(s);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    //Time Complexity O(n^2) as we iterate through a stack within the iteration of another
    //Space Complexity(N) as we use a temporary stack to store values
    private static void sort(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<>();
        while (!s.isEmpty()) {
            //Insert each element in s in sorted order into temp.
            int val = s.pop();
            while (!temp.isEmpty() && temp.peek() > val) {
                s.push(temp.pop());
            }
            temp.push(val);
        }

        //Copy the values from temp back into s
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }

}
